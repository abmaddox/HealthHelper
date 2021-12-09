package edu.towson.maddox.healthhelper.ui.screens.vitals.newvital

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewModelScope
import edu.towson.maddox.healthhelper.ui.components.ItemTypes
import edu.towson.maddox.healthhelper.ui.components.NewItemScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun NewVitalSignScreen(vm : NewVitalSignViewModel,
                        onCancel : ()->Unit){
    NewItemScreen(itemType = ItemTypes.uv, vm = vm, UnitSlot = {

        Text(text = vm.subItems1.value[vm.selectedIndex1.value].unit)

    },
    onCancel = onCancel)
}