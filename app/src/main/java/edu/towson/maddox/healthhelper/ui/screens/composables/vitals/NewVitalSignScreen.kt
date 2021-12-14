package edu.towson.maddox.healthhelper.ui.screens.composables.vitals.newvital

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import edu.towson.maddox.healthhelper.ui.components.BasicEntryField
import edu.towson.maddox.healthhelper.ui.screens.composables.generics.FirstSubitemComposeMenu
import edu.towson.maddox.healthhelper.ui.screens.composables.generics.NewItemScreen
import edu.towson.maddox.healthhelper.ui.screens.composables.generics.SecondSubitemComposeMenu
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.vitals.NewVitalSignViewModel

@Composable
fun NewVitalSignScreen(vm : NewVitalSignViewModel = viewModel(),
                       onCancel : ()->Unit){
NewItemScreen(vm = vm, onCancel =  onCancel ) {
        FirstSubitemComposeMenu(vm = vm, itemType = "vital signs")
        Spacer(modifier = Modifier.padding(10.dp))
        SecondSubitemComposeMenu(vm = vm, itemType = "recording methods")
        Spacer(modifier = Modifier.padding(10.dp))
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            BasicEntryField(
                value = vm.numeric.value.toString(),
                setValue = { vm.updateNumeric(it) },
                label = "Measurement",
                keyboardType = KeyboardType.Number
            )
            Text(text = if (vm.selectedIndex1.value==null)"" else vm.subItems1.value[vm.selectedIndex1.value!!-1].unit)
        }
    }
}