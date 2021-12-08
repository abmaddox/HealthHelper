package edu.towson.maddox.healthhelper.nav

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import edu.towson.maddox.healthhelper.db.DB
import edu.towson.maddox.healthhelper.db.HealthDAO
import edu.towson.maddox.healthhelper.ui.screens.main.home.Home
import edu.towson.maddox.healthhelper.ui.screens.main.login.Login
import edu.towson.maddox.healthhelper.ui.screens.main.login.LoginViewModel
import edu.towson.maddox.healthhelper.ui.screens.main.signup.Signup
import edu.towson.maddox.healthhelper.ui.screens.main.signup.SignupViewModel

@ExperimentalMaterialApi
@Composable
fun Root(db : DB)
{
    Scaffold(
        topBar = {
            Text(text = "Health Helper")
        }
    ) {

        val dao : HealthDAO = db.healthDAO()
        val loginViewModel = LoginViewModel(dao)
        val signupViewModel = SignupViewModel(dao)

        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Routes.Login.route) {

            //Login page with no prefill
            composable(Routes.Login.route){
                Login(vm = loginViewModel,
                onLoginClick = { userId ->
                    navController.navigate(Routes.Home.route + "/${userId}") },
                onSignupClick = { navController.navigate(Routes.Signup.route) }) }

            //Login page with prefilled username after signing up
            composable(Routes.Login.route + "/{username}",
                arguments = listOf(navArgument("username"){ type = NavType.StringType})) {
                Login(username = it.arguments!!.get("username").toString(), vm = loginViewModel,
                onLoginClick = { userId ->
                    navController.navigate(Routes.Home.route + "/${userId}") },
                onSignupClick = { navController.navigate(Routes.Signup.route) }) }

            //Signup page
            composable(Routes.Signup.route) {
                Signup(onSignupClick = {username -> navController.navigate(Routes.Login.route  + "/${username}") },
                onCancelClick = {navController.navigate(Routes.Login.route) }, vm = signupViewModel)
            }

            composable(Routes.Home.route + "/{userId}",
                arguments = listOf(navArgument("userId"){ type = NavType.IntType})) { Home(user_id = it.arguments!!.get("userId") as Int) }

            composable(Routes.Vitals.route + "/{userId}",
                arguments = listOf(navArgument("userId"){ type = NavType.IntType})) { }

            composable(Routes.AddVital.route + "/{userId}",
                arguments = listOf(navArgument("userId"){ type = NavType.IntType})) { }

            composable(Routes.Conditions.route + "/{userId}",
                arguments = listOf(navArgument("userId"){ type = NavType.IntType})) { }

            composable(Routes.AddCondition.route + "/{userId}",
                arguments = listOf(navArgument("userId"){ type = NavType.IntType})) { }

            composable(Routes.Medications.route + "/{userId}",
                arguments = listOf(navArgument("userId"){ type = NavType.IntType})) { }

            composable(Routes.AddMedication.route + "/{userId}",
                arguments = listOf(navArgument("userId"){ type = NavType.IntType})) { }

            composable(Routes.RiskFactors.route + "/{userId}",
                arguments = listOf(navArgument("userId"){ type = NavType.IntType})) { }

            composable(Routes.AddRiskFactor.route + "/{userId}",
                arguments = listOf(navArgument("userId"){ type = NavType.IntType})) { }

            composable(Routes.Surveys.route + "/{userId}",
                arguments = listOf(navArgument("userId"){ type = NavType.IntType})) { }

            composable(Routes.TakeSurvey.route + "/{userId}",
                arguments = listOf(navArgument("userId"){ type = NavType.IntType})) { }
        }
    }
}
