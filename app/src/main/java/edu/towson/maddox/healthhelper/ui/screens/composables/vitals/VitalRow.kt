package edu.towson.maddox.healthhelper.ui.screens.composables.vitals

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import edu.towson.maddox.healthhelper.data.model.vitals.uVitals
import edu.towson.maddox.healthhelper.ui.components.Header
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.vitals.VitalSignListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Composable
fun VitalRow(vm : VitalSignListViewModel, item : uVitals){
    Header(text = vm.getSubItem1(item.vital_id).type)
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth())
    {
        Text(text = "Measurement: ${item.measurement} ${vm.getSubItem1(item.vital_id).unit}")
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth())
    {
        Text(text = "Recording Method: ${vm.subItems2}")
        Text(text = "Recorded At: ${item.timestamp}")
    }
}