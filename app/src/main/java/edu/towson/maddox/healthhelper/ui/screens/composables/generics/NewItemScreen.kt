package edu.towson.maddox.healthhelper.ui.screens.composables.generics

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.towson.maddox.healthhelper.ui.components.ComposeMenu
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.generics.INewItemViewModel
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.generics.NewItemViewModel

@Composable
fun <A,B,C,D>NewItemScreen(
    vm: NewItemViewModel<A, B, C, D>,
    onCancel: () -> Unit,
    Slot: @Composable () -> Unit = {}
)
{
    val ctx = LocalContext.current
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Slot()
        if (vm.isErrorPopupVisible.value)
        {
            AlertDialog(onDismissRequest = { vm.toggleErrorPopupVisible() },
                confirmButton = {
                Button(
                    onClick = { vm.toggleErrorPopupVisible() }) {
                    Text(text = "Okay")
                }
            },
            title = { Text(text ="Error: Fields were left blank", fontSize = 20.sp) },
            text = { Text(text = "Please fill out all fields before saving.") })
        }
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = {
                try
                {
                    vm.addUserItem()
                    Toast.makeText(ctx,"Item added!", Toast.LENGTH_LONG ).show()
                    onCancel()
                }
                catch (e : Exception){ Log.d("new item error", e.toString())}

            })
            {
                Text(text = "Save item")
            }
            
            Spacer(modifier = Modifier.padding(20.dp))

            Button(onClick = { onCancel() })
            {
                Text(text = "Cancel")
            }
        }
    }
}
@Composable
fun<A, B, C, D> FirstSubitemComposeMenu(vm : INewItemViewModel<A, B, C, D>, itemType : String){
    ComposeMenu(
        menuItems = listOf("")+ vm.subItems1.value.map { A -> A.toString() },
        menuExpandedState = vm.isMenu1Expanded.value,
        itemTypes = itemType,
        toggleMenuExpandStatus = { vm.toggleMenu1Expansion(b = null) },
        onDismissMenuView = { vm.toggleMenu1Expansion(b = false) },
        onMenuItemClick = {vm.setSelectedIndex1(it)},
        selectedIndex = vm.selectedIndex1.value
    )
}

@Composable
fun<A, B, C, D> SecondSubitemComposeMenu( vm : INewItemViewModel<A, B, C, D>, itemType : String){
    ComposeMenu(
        menuItems = listOf("")+ vm.subItems2.value.map { B -> B.toString() },
        menuExpandedState = vm.isMenu2Expanded.value,
        itemTypes = itemType,
        toggleMenuExpandStatus = { vm.toggleMenu2Expansion(b = null) },
        onDismissMenuView = { vm.toggleMenu2Expansion(b = false) },
        onMenuItemClick = {vm.setSelectedIndex2(it)},
        selectedIndex = vm.selectedIndex2.value
    )
}

@Composable
fun<A, B, C, D> ThirdSubitemComposeMenu( vm : INewItemViewModel<A, B, C, D>, itemType : String){
    ComposeMenu(
        menuItems = listOf("")+ vm.subItems3.value.map { C -> C.toString() },
        menuExpandedState = vm.isMenu3Expanded.value,
        itemTypes = itemType,
        toggleMenuExpandStatus = { vm.toggleMenu3Expansion(b = null) },
        onDismissMenuView = { vm.toggleMenu3Expansion(b = false) },
        onMenuItemClick = {vm.setSelectedIndex3(it)},
        selectedIndex = vm.selectedIndex3.value
    )
}

@Composable
fun<A, B, C, D> FourthSubitemComposeMenu( vm : INewItemViewModel<A, B, C, D>, itemType : String){
    ComposeMenu(
        menuItems = listOf("")+ vm.subItems4.value.map { D -> D.toString() },
        menuExpandedState = vm.isMenu4Expanded.value,
        itemTypes = itemType,
        toggleMenuExpandStatus = { vm.toggleMenu4Expansion(b = null) },
        onDismissMenuView = { vm.toggleMenu4Expansion(b = false) },
        onMenuItemClick = {vm.setSelectedIndex4(it)},
        selectedIndex = vm.selectedIndex4.value
    )
}
