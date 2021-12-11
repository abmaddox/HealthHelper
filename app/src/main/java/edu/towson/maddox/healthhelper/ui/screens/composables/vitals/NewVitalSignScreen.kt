package edu.towson.maddox.healthhelper.ui.screens.composables.vitals.newvital

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import edu.towson.maddox.healthhelper.ui.components.ItemTypes
import edu.towson.maddox.healthhelper.ui.components.NewItemScreen
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.vitals.NewVitalSignViewModel

@Composable
fun NewVitalSignScreen(vm : NewVitalSignViewModel,
                       onCancel : ()->Unit){
    NewItemScreen(itemType = ItemTypes.uv, vm = vm, UnitSlot = {

        Text(text = vm.subItems1.value[vm.selectedIndex1.value].unit)

    },
    onCancel = onCancel)
}