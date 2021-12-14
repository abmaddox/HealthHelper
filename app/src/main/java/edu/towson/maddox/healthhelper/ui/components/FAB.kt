package edu.towson.maddox.healthhelper.ui.components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun FAB(onClick:()->Unit,
        modifier: Modifier = Modifier) {
    FloatingActionButton(onClick = {onClick()}, modifier = modifier) {
        Icon(Icons.Filled.Add, contentDescription = null, tint = Color.Black)
    }
}