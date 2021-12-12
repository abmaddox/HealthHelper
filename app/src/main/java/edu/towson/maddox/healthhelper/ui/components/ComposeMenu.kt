package edu.towson.maddox.healthhelper.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ComposeMenu(
    menuItems: List<String>,
    menuExpandedState: Boolean = false,
    itemTypes : String,
    updateMenuExpandStatus: () -> Unit,
    onDismissMenuView: () -> Unit,
    onMenuItemClick: (Int) -> Unit,
) {     Box(modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.TopStart)) {
        IconButton(onClick = { updateMenuExpandStatus() }) {
            Icon(Icons.Default.MoreVert, contentDescription = "Click to display $itemTypes to choose from")
        }
        DropdownMenu(
            expanded = menuExpandedState,
            onDismissRequest = { onDismissMenuView() }
        ) {
            menuItems.mapIndexed {idx, s->
                DropdownMenuItem(onClick = { onMenuItemClick(idx)}) {
                    Text(text = s)
                }
            }
        }
    }
}