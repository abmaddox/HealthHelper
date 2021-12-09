package edu.towson.maddox.healthhelper.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import edu.towson.maddox.healthhelper.data.model.vm.INewItemViewModel
import edu.towson.maddox.healthhelper.data.model.vm.NewItemViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun <A,B,C,D> NewItemScreen(
    itemType: ItemTypes,
    vm: NewItemViewModel<A, B, C, D>,
    UnitSlot : @Composable () -> Unit = {},
    onCancel : () -> Unit
){
    Column(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when(itemType){
            ItemTypes.urf -> {
                FirstSubitemComposeMenu(vm = vm)
                Spacer(modifier = Modifier.padding(10.dp))
            }
            ItemTypes.uc, ItemTypes.us  -> {
                FirstSubitemComposeMenu(vm = vm)
                Spacer(modifier = Modifier.padding(10.dp))
                StartEndDatePicker(vm = vm)
            }
            ItemTypes.uv -> {
                FirstSubitemComposeMenu(vm = vm)
                Spacer(modifier = Modifier.padding(10.dp))
                SecondSubitemComposeMenu(vm = vm)
                Spacer(modifier = Modifier.padding(10.dp))
                Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                    BasicEntryField(value = vm.numeric.value.toString(), setValue = {vm.updateNumeric(it)}, label = "Measurement", keyboardType = KeyboardType.Number)
                    UnitSlot()
                }
            }
            ItemTypes.umed -> {
                FirstSubitemComposeMenu(vm = vm)
                Spacer(modifier = Modifier.padding(10.dp))
                SecondSubitemComposeMenu(vm = vm)
                Spacer(modifier = Modifier.padding(10.dp))
                Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                    BasicEntryField(value = vm.numeric.value.toString(), setValue = {vm.updateNumeric(it)}, label = "Dosage", keyboardType = KeyboardType.Number)
                    UnitSlot()
                }
                Spacer(modifier = Modifier.padding(10.dp))
                StartEndDatePicker(vm = vm)
                Spacer(modifier = Modifier.padding(10.dp))
                BasicEntryField(value = vm.textEntry.value, setValue = {vm.updateTextEntry(it)}, label = "Reason for taking:", keyboardType = KeyboardType.Text)
            }
        }
        Row(modifier = Modifier.fillMaxWidth() ,horizontalArrangement = Arrangement.SpaceEvenly ) {
            Button(onClick = { vm.viewModelScope.launch(Dispatchers.IO) { vm.addUserItem() } ; onCancel() }) {
                Text(text = "Add item")
            }

            Button(onClick = { onCancel() }) {
                Text(text = "Cancel")
            }
        }
    }
}

@Composable
fun<A, B, C, D> FirstSubitemComposeMenu( vm : INewItemViewModel<A, B, C, D>){
    ComposeMenu(
        menuItems = vm.subItems1.value.map { A -> A.toString() },
        menuExpandedState = vm.isMenu1Expanded.value,
        selectedIndex = vm.selectedIndex1.value,
        updateMenuExpandStatus = { vm.toggleMenu1Expansion(b = null) },
        onDismissMenuView = { vm.toggleMenu1Expansion(b = false) },
        onMenuItemClick = {vm.setSelectedConditionIndex1(it)}
    )
}

@Composable
fun<A, B, C, D> SecondSubitemComposeMenu( vm : INewItemViewModel<A, B, C, D>){
    ComposeMenu(
        menuItems = vm.subItems2.value.map { B -> B.toString() },
        menuExpandedState = vm.isMenu2Expanded.value,
        selectedIndex = vm.selectedIndex2.value,
        updateMenuExpandStatus = { vm.toggleMenu2Expansion(b = null) },
        onDismissMenuView = { vm.toggleMenu2Expansion(b = false) },
        onMenuItemClick = {vm.setSelectedConditionIndex2(it)}
    )
}

@Composable
fun<A, B, C, D> ThirdSubitemComposeMenu( vm : INewItemViewModel<A, B, C, D>){
    ComposeMenu(
        menuItems = vm.subItems3.value.map { C -> C.toString() },
        menuExpandedState = vm.isMenu3Expanded.value,
        selectedIndex = vm.selectedIndex3.value,
        updateMenuExpandStatus = { vm.toggleMenu3Expansion(b = null) },
        onDismissMenuView = { vm.toggleMenu3Expansion(b = false) },
        onMenuItemClick = {vm.setSelectedConditionIndex3(it)}
    )
}

@Composable
fun<A, B, C, D> FourthSubitemComposeMenu( vm : INewItemViewModel<A, B, C, D>){
    ComposeMenu(
        menuItems = vm.subItems4.value.map { D -> D.toString() },
        menuExpandedState = vm.isMenu4Expanded.value,
        selectedIndex = vm.selectedIndex4.value,
        updateMenuExpandStatus = { vm.toggleMenu4Expansion(b = null) },
        onDismissMenuView = { vm.toggleMenu4Expansion(b = false) },
        onMenuItemClick = {vm.setSelectedConditionIndex4(it)}
    )
}


