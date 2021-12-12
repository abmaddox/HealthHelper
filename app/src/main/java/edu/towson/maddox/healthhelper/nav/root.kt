package edu.towson.maddox.healthhelper.nav

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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.towson.maddox.healthhelper.R
import edu.towson.maddox.healthhelper.ui.screens.composables.conditions.ConditionList
import edu.towson.maddox.healthhelper.ui.screens.composables.conditions.NewConditionScreen
import edu.towson.maddox.healthhelper.ui.screens.composables.main.Home
import edu.towson.maddox.healthhelper.ui.screens.composables.main.Login
import edu.towson.maddox.healthhelper.ui.screens.composables.main.Signup
import edu.towson.maddox.healthhelper.ui.screens.composables.medications.MedicationList
import edu.towson.maddox.healthhelper.ui.screens.composables.medications.NewMedicationScreen
import edu.towson.maddox.healthhelper.ui.screens.composables.riskfactors.NewRiskFactorScreen
import edu.towson.maddox.healthhelper.ui.screens.composables.riskfactors.RiskFactorsList
import edu.towson.maddox.healthhelper.ui.screens.composables.symptoms.NewSymptomScreen
import edu.towson.maddox.healthhelper.ui.screens.composables.symptoms.SymptomsList
import edu.towson.maddox.healthhelper.ui.screens.composables.vitals.VitalSignList
import edu.towson.maddox.healthhelper.ui.screens.composables.vitals.newvital.NewVitalSignScreen
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.conditions.ConditionListViewModel
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.conditions.NewConditionViewModel
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.main.LoginViewModel
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.main.SignupViewModel
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.medications.MedListViewModel
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.medications.NewMedViewModel
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.riskfactors.NewRiskFactorViewModel
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.riskfactors.RiskFactorsListViewModel
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.symptoms.NewSymptomViewModel
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.symptoms.SymptomsListViewModel
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.vitals.NewVitalSignViewModel
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.vitals.VitalSignListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun Root() {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
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
            val userId = rememberSaveable { mutableStateOf(0) }
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = Routes.Login.route) {

                //Login page
                composable(Routes.Login.route)
                {
                    val loginViewModel : LoginViewModel = viewModel()
                    Login(vm = loginViewModel,
                        onLoginClick = { user_id ->
                            userId.value = user_id
                            navController.navigate(Routes.Home.route){
                                launchSingleTop = true
                            }
                        },
                        onSignupClick = { navController.navigate(Routes.Signup.route){
                            launchSingleTop = true
                        } })
                }

                //Signup page
                composable(Routes.Signup.route)
                {
                    val signupViewModel : SignupViewModel = viewModel()
                    Signup(onSignupClick = { navController.navigate(Routes.Login.route){
                        launchSingleTop = true
                    } },
                        onCancelClick = { navController.navigate(Routes.Login.route){
                            launchSingleTop = true
                        } },
                        vm = signupViewModel
                    )
                }


                //Main menu
                composable(Routes.Home.route)
                {
                    Home(
                        user_id = userId.value,
                        onConditionsClick = {
                            navController.navigate(Routes.Conditions.route){
                                launchSingleTop = true
                            }
                        },
                        onMedicationsClick = {
                            navController.navigate(Routes.Medications.route){
                                launchSingleTop = true
                            }
                        },
                        onRiskFactorsClick = {
                            navController.navigate(Routes.RiskFactors.route){
                                launchSingleTop = true
                            }
                        },
                        onSymptomsClick = {
                            navController.navigate(Routes.Symptoms.route){
                                launchSingleTop = true
                            }
                        },
                        onVitalsClick = {
                            navController.navigate(Routes.Vitals.route){
                                launchSingleTop = true
                            }
                        }
                    )
                }


                //VITALS

                //Vital Sign main page
                composable(Routes.Vitals.route)
                {
                    val vitalsListViewModel : VitalSignListViewModel = viewModel()
                    VitalSignList(vm = vitalsListViewModel) {
                        navController.navigate(Routes.AddVital.route){
                            launchSingleTop = true
                        }
                    }
                }

                //Add new vital sign page
                composable(Routes.AddVital.route)
                {
                    val newVitalSignViewModel : NewVitalSignViewModel = viewModel()
                    NewVitalSignScreen(vm = newVitalSignViewModel)
                    {
                        navController.navigate(Routes.Vitals.route)
                        {
                            launchSingleTop = true
                        }
                    }
                }


                //CONDITIONS

                //Conditions main page
                composable(Routes.Conditions.route)
                {
                    val conditionListViewModel : ConditionListViewModel = viewModel()
                    ConditionList(vm = conditionListViewModel,
                        onClickFAB = {
                            navController.navigate(Routes.AddCondition.route)
                            {
                        launchSingleTop = true
                    }})
                }

                //Add new condition page
                composable(Routes.AddCondition.route)
                {
                    val newConditionViewModel : NewConditionViewModel = viewModel()
                    NewConditionScreen(vm = newConditionViewModel) {
                        navController.navigate(Routes.Conditions.route){
                            launchSingleTop = true
                        }
                    }
                }


                //MEDICATIONS

                //Medications main page
                composable(Routes.Medications.route)
                {
                    val medListViewModel : MedListViewModel = viewModel()
                    MedicationList(vm = medListViewModel) {
                        navController.navigate(Routes.AddMedication.route){
                            launchSingleTop = true
                        }
                    }
                }
                //Add new medication page
                composable(Routes.AddMedication.route)
                {
                    val newMedViewModel : NewMedViewModel = viewModel()
                    NewMedicationScreen(vm = newMedViewModel) {
                        navController.navigate(Routes.Medications.route){
                            launchSingleTop = true
                        }
                    }
                }


                //RISK_FACTORS
                //Risk factors main page
                composable(Routes.RiskFactors.route)
                {
                    val riskFactorsListViewModel : RiskFactorsListViewModel = viewModel()
                    RiskFactorsList(vm = riskFactorsListViewModel) {
                        navController.navigate(Routes.AddRiskFactor.route){
                            launchSingleTop = true
                        }
                    }
                }
                //Add new risk factor page
                composable(Routes.AddRiskFactor.route)
                {
                    val newRiskFactorViewModel : NewRiskFactorViewModel = viewModel()
                    NewRiskFactorScreen(vm = newRiskFactorViewModel) {
                        navController.navigate(Routes.RiskFactors.route){
                            launchSingleTop = true
                        }
                    }
                }


                //SYMPTOMS
                //Symptoms main page
                composable(Routes.Symptoms.route)
                {
                    val symptomsListViewModel : SymptomsListViewModel = viewModel()
                    SymptomsList(vm = symptomsListViewModel) {
                        navController.navigate(Routes.AddSymptom.route){
                            launchSingleTop = true
                        }
                    }
                }
                //Add new symptom page
                composable(Routes.AddSymptom.route)
                {
                    val newSymptomListViewModel : NewSymptomViewModel = viewModel()
                    NewSymptomScreen(vm = newSymptomListViewModel) {
                        navController.navigate(Routes.Symptoms.route){
                            launchSingleTop = true
                        }
                    }
                }
            }
        }
    }

