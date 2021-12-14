package edu.towson.maddox.healthhelper.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ComposeMenu(
    selectedIndex : Int?,
    menuItems: List<String>,
    menuExpandedState: Boolean = false,
    itemTypes : String,
    toggleMenuExpandStatus: () -> Unit,
    onDismissMenuView: () -> Unit,
    onMenuItemClick: (Int) -> Unit
)
{
    Column(modifier = Modifier
        .padding(horizontal = 15.dp)
        .fillMaxWidth(),
    verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(text = "Click the arrow to display $itemTypes to choose from")
        Row(
            modifier = Modifier
                .fillMaxWidth())
        {
            Column(horizontalAlignment = Alignment.Start) {
                TextField(value = if (selectedIndex == null) "" else menuItems[selectedIndex],
                    onValueChange = {},
                    readOnly = true,
                    modifier = Modifier.clickable { toggleMenuExpandStatus() })
            }
            Column {
                IconButton(onClick = { toggleMenuExpandStatus() }) {
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "Click to display $itemTypes to choose from"
                    )
                }
            }
        }

        DropdownMenu(
            expanded = menuExpandedState,
            onDismissRequest = { onDismissMenuView() }
        ) {
            menuItems.mapIndexed { idx, s ->
                DropdownMenuItem(onClick = { onMenuItemClick(idx) }, enabled = idx!=0) {
                    Text(text = s)
                }
            }
        }
    }
}

@Composable
@Preview
fun ComposeMenuTest(){
    val isMenuVisible = rememberSaveable { mutableStateOf(false) }
    val selectedIndex = rememberSaveable { mutableStateOf(0) }
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        ComposeMenu(
            menuItems = listOf("")+(0..30).map { it.toString() },
            itemTypes = "numbers",
            toggleMenuExpandStatus = { isMenuVisible.value = !isMenuVisible.value },
            onDismissMenuView = { isMenuVisible.value = false },
            onMenuItemClick = { selectedIndex.value = it},
            selectedIndex = selectedIndex.value
        )
    }

}