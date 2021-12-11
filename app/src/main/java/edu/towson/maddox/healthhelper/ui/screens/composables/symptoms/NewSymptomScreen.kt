package edu.towson.maddox.healthhelper.ui.screens.composables.symptoms

import androidx.compose.runtime.Composable
import edu.towson.maddox.healthhelper.ui.components.ItemTypes
import edu.towson.maddox.healthhelper.ui.components.NewItemScreen
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.symptoms.NewSymptomViewModel

@Composable
fun NewSymptomScreen(vm : NewSymptomViewModel,
                     onCancel : ()->Unit){
    NewItemScreen(itemType = ItemTypes.us, vm = vm, onCancel = onCancel)
}