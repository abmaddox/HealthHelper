package edu.towson.maddox.healthhelper.ui.screens.medications.medlist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import edu.towson.maddox.healthhelper.data.model.medications.uMedications

@ExperimentalFoundationApi
@Composable
fun MedList(onDelete: (uMedications) -> Unit,
            vm : MedListViewModel,
            fab : @Composable () -> Unit = {}){
    Scaffold(
        floatingActionButton = fab,
        floatingActionButtonPosition = FabPosition.End,
        isFloatingActionButtonDocked = true
    ) {
        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()){
            itemsIndexed(vm.userItems.value){
                    _, umed ->
                UMedicationRow(
                    med = vm.getSubItem1(umed.medication_id),
                    freq = vm.getSubItem2(umed.frequency_id),
                    method = vm.getSubItem3(umed.method_id),
                    unit = vm.getSubItem4(umed.unit_id),
                    uMedications = umed,
                    onDelete = { onDelete(umed) }
                )
            }
        }
    }
}
