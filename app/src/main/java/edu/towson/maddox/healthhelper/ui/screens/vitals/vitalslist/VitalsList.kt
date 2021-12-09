package edu.towson.maddox.healthhelper.ui.screens.vitals.vitalslist

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import edu.towson.maddox.healthhelper.data.model.vitals.uVitals

@Composable
fun VitalsList(onDelete: (uVitals) -> Unit,
               vm : VitalsListViewModel,
               fab : @Composable () -> Unit = {}){
    Scaffold(
        floatingActionButton = fab,
        floatingActionButtonPosition = FabPosition.End,
        isFloatingActionButtonDocked = true
    ) {
        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()){
            itemsIndexed(vm.userVitals.value){
                    _, uv ->
                UVitalsRow(
                    vital = vm.getVital(uv.vital_id),
                    methodName = vm.getMethod(uv.rMethod_id),
                    ts = uv.timestamp,
                    meas = uv.measurement,
                    onDelete = onDelete
                )
            }
        }
    }
}