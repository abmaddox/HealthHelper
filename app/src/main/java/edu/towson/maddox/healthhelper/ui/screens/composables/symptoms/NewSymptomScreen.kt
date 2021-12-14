package edu.towson.maddox.healthhelper.ui.screens.composables.symptoms

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import edu.towson.maddox.healthhelper.ui.components.StartEndDatePicker
import edu.towson.maddox.healthhelper.ui.screens.composables.generics.FirstSubitemComposeMenu
import edu.towson.maddox.healthhelper.ui.screens.composables.generics.NewItemScreen
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.symptoms.NewSymptomViewModel

@Composable
fun NewSymptomScreen(vm : NewSymptomViewModel,
                     onCancel : ()->Unit){
    NewItemScreen(vm = vm, onCancel = onCancel) {
        FirstSubitemComposeMenu(vm = vm, itemType = "symptoms")
        Spacer(modifier = Modifier.padding(10.dp))
        StartEndDatePicker(vm = vm)
    }
}