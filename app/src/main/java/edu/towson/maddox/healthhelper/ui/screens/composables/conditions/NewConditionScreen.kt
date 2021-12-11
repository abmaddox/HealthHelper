package edu.towson.maddox.healthhelper.ui.screens.composables.conditions

import androidx.compose.runtime.Composable
import edu.towson.maddox.healthhelper.ui.components.ItemTypes
import edu.towson.maddox.healthhelper.ui.components.NewItemScreen
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.conditions.NewConditionViewModel

@Composable
fun NewConditionScreen(vm : NewConditionViewModel,
                       onCancel : ()->Unit){
    NewItemScreen(itemType = ItemTypes.uc, vm = vm, onCancel = onCancel)
}