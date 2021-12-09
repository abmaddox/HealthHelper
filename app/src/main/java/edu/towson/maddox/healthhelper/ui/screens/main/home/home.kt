package edu.towson.maddox.healthhelper.ui.screens.main.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Home(
        user_id: Int,
        onMedicationsClick: (Int) -> Unit,
        onConditionsClick: (Int) -> Unit,
        onRiskFactorsClick: (Int) -> Unit,
        onVitalsClick: (Int) -> Unit,
        onSymptomsClick: (Int) -> Unit,
){
        Column(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly) {


                        Button(onClick = {onMedicationsClick(user_id)}) {
                                Text(text = "Medications")
                        }

                        Button(onClick = {onConditionsClick(user_id)}) {
                                Text(text = "Medical Conditions")
                        }



                        Button(onClick = {onRiskFactorsClick(user_id)}) {
                                Text(text = "Risk Factors")
                        }

                        Button(onClick = {onVitalsClick(user_id)}) {
                                Text(text = "Vital Signs")
                        }


                        Button(onClick = {onSymptomsClick(user_id)}) {
                                Text(text = "Symptoms")

                        }
                }
        }
