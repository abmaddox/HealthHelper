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

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth())
    {
        Header(text = vm.getSubItem1(item.vital_id).type)
        Text(text = "Measurement: ${item.measurement} ${vm.getSubItem1(item.vital_id).unit}")
        Text(text = "Recording Method: ${vm.getSubItem2(item.rMethod_id)}")
        Text(text = "Recorded At: ${item.timestamp}")
    }
}