package edu.towson.maddox.healthhelper.nav

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import edu.towson.maddox.healthhelper.R
import edu.towson.maddox.healthhelper.data.model.conditions.Condition
import edu.towson.maddox.healthhelper.data.model.conditions.uConditions
import edu.towson.maddox.healthhelper.data.model.medications.uMedications
import edu.towson.maddox.healthhelper.data.model.riskFactors.RiskFactor
import edu.towson.maddox.healthhelper.data.model.riskFactors.uRiskFactors
import edu.towson.maddox.healthhelper.data.model.symptoms.uSymptoms
import edu.towson.maddox.healthhelper.data.model.vitals.uVitals
import edu.towson.maddox.healthhelper.data.repo.HealthRepo
import edu.towson.maddox.healthhelper.db.DB
import edu.towson.maddox.healthhelper.ui.screens.main.home.Home
import edu.towson.maddox.healthhelper.ui.screens.main.login.Login
import edu.towson.maddox.healthhelper.ui.screens.main.login.LoginViewModel
import edu.towson.maddox.healthhelper.ui.screens.main.signup.Signup
import edu.towson.maddox.healthhelper.ui.screens.main.signup.SignupViewModel
import edu.towson.maddox.healthhelper.ui.screens.vitals.newvital.NewVitalSignScreen
import edu.towson.maddox.healthhelper.ui.screens.vitals.newvital.NewVitalSignViewModel
import edu.towson.maddox.healthhelper.ui.screens.vitals.vitalslist.VitalsListViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.util.*

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun Root(db : DB, scope : CoroutineScope)
{
    Scaffold(
        topBar = {
            Row(modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                Spacer(Modifier.padding(vertical = 10.dp))
                Icon(
                    painter = painterResource(id = R.drawable.health_helper_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp, 30.dp)
                )
                Text(text = "Health Helper", fontSize = 30.sp)
            }
        }
    ) {

        val repo = HealthRepo(db.healthDAO())

        testDatabaseFill(scope, repo)

        val loginViewModel = LoginViewModel(repo)
        val signupViewModel = SignupViewModel(repo)
        val userId  = rememberSaveable { mutableStateOf(0) }
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Routes.Login.route) {

            //Login page with no prefill
            composable(Routes.Login.route){
                Login(vm = loginViewModel,
                onLoginClick = { user_id -> userId.value = user_id
                    navController.navigate(Routes.Home.route) },
                onSignupClick = { navController.navigate(Routes.Signup.route) }) }

            //Login page with prefilled username after signing up
            composable(Routes.Login.route + "/{username}",
                arguments = listOf(navArgument("username"){ type = NavType.StringType})) {
                Login(username = it.arguments!!.get("username").toString(), vm = loginViewModel,
                onLoginClick = { user_id -> userId.value = user_id
                    navController.navigate(Routes.Home.route) },
                onSignupClick = { navController.navigate(Routes.Signup.route) }) }

            //Signup page
            composable(Routes.Signup.route) {
                Signup(onSignupClick = {username -> navController.navigate(Routes.Login.route  + "/${username}") },
                onCancelClick = {navController.navigate(Routes.Login.route) }, vm = signupViewModel)
            }


            //Main menu
            composable(Routes.Home.route) {
                Home(
                    user_id = userId.value,
                    onConditionsClick = {
                        navController.navigate(Routes.Conditions.route)
                    },
                    onMedicationsClick = {
                        navController.navigate(Routes.Medications.route)
                    },
                    onRiskFactorsClick = {
                        navController.navigate(Routes.RiskFactors.route)
                    },
                    onSymptomsClick = {
                        navController.navigate(Routes.Symptoms.route)
                    },
                    onVitalsClick = {
                        navController.navigate(Routes.Vitals.route)
                    }
                )
            }

            val vitalsListViewModel = VitalsListViewModel(repo, userId.value)
            val newVitalSignViewModel = NewVitalSignViewModel(repo, user_id = userId.value)
    //VITALS
            //Vital Sign main page
            composable(Routes.Vitals.route) {  }

            //Add new vital sign page
            composable(Routes.AddVital.route) {
                NewVitalSignScreen(vm = newVitalSignViewModel) {
                navController.navigate(Routes.Vitals.route){
                    launchSingleTop = true
                }
            } }


    //CONDITIONS
            //Conditions main page
            composable(Routes.Conditions.route) {  }

            //Add new condition page
            composable(Routes.AddCondition.route) {  }



    //MEDICATIONS
            //Medications main page
            composable(Routes.Medications.route){  }
            //Add new medication page
            composable(Routes.AddMedication.route) {  }



    //RISK_FACTORS
            //Risk factors main page
            composable(Routes.RiskFactors.route) { }
            //Add new risk factor page
            composable(Routes.AddRiskFactor.route) { }



    //SYMPTOMS
            //Symptoms main page
            composable(Routes.Symptoms.route){  }
            //Add new symptom page
            composable(Routes.AddSymptom.route) {  }
        }
    }
}

fun testDatabaseFill(scope : CoroutineScope, repo: HealthRepo) {
    scope.launch(Dispatchers.IO) {
        val clist = scope.async(Dispatchers.IO) { repo.getConditions() }
        scope.launch(Dispatchers.IO)
        {
            if (clist.isCompleted) {
                Log.d("testing", clist.await().toString())
                if (clist.await().isEmpty()){
                    repo.insertConditions(Condition(0, "Influenza"))
                    repo.insertConditions(Condition(0, "Influenza"))
                    repo.insertRiskFactors(RiskFactor(0, "Obesity"))
                    repo.insertRiskFactors(RiskFactor(0, "Asthma"))
                    repo.insertUserConditions(uConditions(1,1,Calendar.getInstance().time,null))
                    repo.insertUserRiskFactors(uRiskFactors(1,1))
                    repo.insertUserRiskFactors(uRiskFactors(1,2))
                }
            }
        }
    }
}


fun runDelete(repo : HealthRepo, scope: CoroutineScope, umed : uMedications?=null, urf : uRiskFactors?=null, us : uSymptoms? =null, uv : uVitals?=null, uc : uConditions?=null ){
    scope.launch{
        if (umed != null)
            repo.deleteUserMeds(umed)
        if (urf != null)
            repo.deleteUserRiskFactors(urf)
        if (us != null)
            repo.deleteUserSymptoms(us)
        if (uv != null)
            repo.deleteUserVital(uv)
        if (uc != null)
            repo.deleteUserConditions(uc)
    }
}

