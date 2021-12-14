package edu.towson.maddox.healthhelper.ui.screens.composables.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Home(
        onMedicationsClick: () -> Unit,
        onConditionsClick: () -> Unit,
        onRiskFactorsClick: () -> Unit,
        onVitalsClick: () -> Unit,
        onSymptomsClick: () -> Unit,
){
        Column(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly)
        {

                
                Button(onClick = {onMedicationsClick()}) {
                        Text(text = "Medications")
                }

                Button(onClick = {onConditionsClick()}) {
                        Text(text = "Medical Conditions")
                }



                Button(onClick = {onRiskFactorsClick()}) {
                        Text(text = "Risk Factors")
                }

                Button(onClick = {onVitalsClick()}) {
                        Text(text = "Vital Signs")
                }


                Button(onClick = {onSymptomsClick()}) {
                        Text(text = "Symptoms")
                }
        }
}

