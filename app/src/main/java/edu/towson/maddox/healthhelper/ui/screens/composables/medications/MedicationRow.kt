package edu.towson.maddox.healthhelper.ui.screens.composables.medications

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import edu.towson.maddox.healthhelper.data.model.medications.uMedications
import edu.towson.maddox.healthhelper.ui.components.Header
import edu.towson.maddox.healthhelper.ui.screens.composables.generics.StartAndEndDateText
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.medications.MedListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Composable
fun MedicationRow(vm : MedListViewModel,
                  item : uMedications){
    Header(text = vm.getSubItem1(item.medication_id).toString() + "Dosage: ${item.dosage} ${vm.getSubItem4(item.unit_id)}")
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth())
    {
        Text(text = "Frequency : ${vm.getSubItem2(item.frequency_id)}")
        Text(text = "Administration Method: ${vm.getSubItem3(item.method_id)}")
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth())
    {
        StartAndEndDateText(uMedications = item)
        Text(text = "Reason For Taking : ${item.reason}")
    }
}