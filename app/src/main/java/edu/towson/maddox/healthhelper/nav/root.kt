package edu.towson.maddox.healthhelper.nav

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.towson.maddox.healthhelper.R
import edu.towson.maddox.healthhelper.ui.components.Header
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
import edu.towson.maddox.healthhelper.ui.screens.composables.vitals.NewVitalSignScreen
import edu.towson.maddox.healthhelper.ui.screens.composables.vitals.VitalSignList
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
fun Root(vm : RootViewModel) {
    Scaffold(
        topBar = {
            Column(modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.secondary),
            horizontalAlignment = Alignment.CenterHorizontally) {
                Row(
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.health_helper_logo),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp, 30.dp)
                    )
                    Text(text = "Health Helper", fontSize = 30.sp)
                }
                Divider(thickness = 5.dp, color = Color.LightGray)
            }

        }
    ) {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = Routes.Login.route) {

                //Login page
                composable(Routes.Login.route)
                {
                    val loginViewModel = LoginViewModel(vm.repo)
                    Login(vm = loginViewModel,
                        onLoginClick = { user_id ->
                            vm.repo.setUserId(user_id)
                            vm.repo.loadUserItems()
                            navController.navigate(Routes.Loading.route)
                        },
                        onSignupClick = { navController.navigate(Routes.Signup.route){
                            launchSingleTop = true
                        } })
                }

                //Signup page
                composable(Routes.Signup.route)
                {
                    val signupViewModel = SignupViewModel(vm.repo)
                    Signup(onSignupClick = { navController.navigate(Routes.Login.route){
                        launchSingleTop = true
                    } },
                        onCancelClick = { navController.navigate(Routes.Login.route){
                            launchSingleTop = true
                        } },
                        vm = signupViewModel
                    )
                }

                composable(Routes.Loading.route){
                    Column(modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center)
                    {
                        Header(text = "Loading, please wait.")
                        CircularProgressIndicator()
                        if(!vm.waiting.value){
                            navController.navigate(Routes.Home.route){
                                launchSingleTop = true
                            }
                        }
                        else
                            vm.checkWaiting()
                    }
                }


                //Main menu
                composable(Routes.Home.route)
                {
                    Home(
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
                    val vitalsListViewModel = VitalSignListViewModel(vm.repo)
                    VitalSignList(vm = vitalsListViewModel) {
                        navController.navigate(Routes.AddVital.route){
                            launchSingleTop = true
                        }
                    }
                }

                //Add new vital sign page
                composable(Routes.AddVital.route)
                {
                    val newVitalSignViewModel = NewVitalSignViewModel(vm.repo)
                    NewVitalSignScreen(vm = newVitalSignViewModel, onCancel = {
                        navController.popBackStack()
                    })
                }


                //CONDITIONS

                //Conditions main page
                composable(Routes.Conditions.route)
                {
                    val conditionListViewModel = ConditionListViewModel(vm.repo)
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
                    val newConditionViewModel = NewConditionViewModel(vm.repo)
                    NewConditionScreen(vm = newConditionViewModel, onCancel = {
                        navController.popBackStack()
                    })
                }


                //MEDICATIONS

                //Medications main page
                composable(Routes.Medications.route)
                {
                    val medListViewModel = MedListViewModel(vm.repo)
                    MedicationList(vm = medListViewModel) {
                        navController.navigate(Routes.AddMedication.route){
                            launchSingleTop = true
                        }
                    }
                }
                //Add new medication page
                composable(Routes.AddMedication.route)
                {
                    val newMedViewModel = NewMedViewModel(vm.repo)
                    NewMedicationScreen(vm = newMedViewModel, onCancel = {
                        navController.popBackStack()
                    })
                }


                //RISK_FACTORS
                //Risk factors main page
                composable(Routes.RiskFactors.route)
                {
                    val riskFactorsListViewModel = RiskFactorsListViewModel(vm.repo)
                    RiskFactorsList(vm = riskFactorsListViewModel) {
                        navController.navigate(Routes.AddRiskFactor.route){
                            launchSingleTop = true
                        }
                    }
                }
                //Add new risk factor page
                composable(Routes.AddRiskFactor.route)
                {
                    val newRiskFactorViewModel = NewRiskFactorViewModel(vm.repo)
                    NewRiskFactorScreen(vm = newRiskFactorViewModel, onCancel = {
                        navController.popBackStack()
                    })
                }


                //SYMPTOMS
                //Symptoms main page
                composable(Routes.Symptoms.route)
                {
                    val symptomsListViewModel = SymptomsListViewModel(vm.repo)
                    SymptomsList(vm = symptomsListViewModel) {
                        navController.navigate(Routes.AddSymptom.route){
                            launchSingleTop = true
                        }
                    }
                }
                //Add new symptom page
                composable(Routes.AddSymptom.route)
                {
                    val newSymptomListViewModel = NewSymptomViewModel(vm.repo)
                    NewSymptomScreen(vm = newSymptomListViewModel, onCancel = {
                        navController.popBackStack()
                    })
                }
            }
        }
    }


