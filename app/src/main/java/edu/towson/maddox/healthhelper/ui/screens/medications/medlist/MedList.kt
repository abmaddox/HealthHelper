package edu.towson.maddox.healthhelper.ui.screens.medications.medlist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import edu.towson.maddox.healthhelper.data.model.medications.*

@ExperimentalFoundationApi
@Composable
fun MedList(onDelete: (uMedications) -> Unit,
            onSelectuMedication: (uMedications) -> Unit,
            vm : MedListViewModel,
            fab : @Composable () -> Unit = {}){
    Scaffold(
        floatingActionButton = fab,
        floatingActionButtonPosition = FabPosition.End,
        isFloatingActionButtonDocked = true
    ) {
        LazyColumn{
            itemsIndexed(vm.userMedications.value){
                    _, umed ->
                UMedicationRow(
                    med = vm.getMed(umed.medication_id),
                    freq = vm.getFreq(umed.frequency_id),
                    method = vm.getMethod(umed.method_id),
                    unit = vm.getUnit(umed.unit_id),
                    uMedications = umed,
                    onDelete = onDelete,
                    onSelectuMedication = onSelectuMedication
                )
            }
        }
    }
}