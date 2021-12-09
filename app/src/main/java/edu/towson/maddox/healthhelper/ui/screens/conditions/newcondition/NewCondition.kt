package edu.towson.maddox.healthhelper.ui.screens.conditions.newcondition

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import edu.towson.maddox.healthhelper.data.model.conditions.uConditions
import edu.towson.maddox.healthhelper.ui.components.ItemTypes
import edu.towson.maddox.healthhelper.ui.components.NewItemScreen

@Composable
fun NewCondition(vm : NewConditionViewModel,
    onCancel: () -> Unit
    ) {
    NewItemScreen(itemType = ItemTypes.uc, vm = vm, onCancel = onCancel )
}