package edu.towson.maddox.healthhelper.ui.screens.composables.medications

import androidx.compose.runtime.Composable
import edu.towson.maddox.healthhelper.ui.components.ItemTypes
import edu.towson.maddox.healthhelper.ui.screens.composables.generics.NewItemScreen
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.medications.NewMedViewModel


@Composable
fun NewMedicationScreen(vm : NewMedViewModel,
                        onCancel : ()->Unit){
    NewItemScreen(itemType = ItemTypes.uv, vm = vm, onCancel = onCancel, recordType = ItemTypes.numed.toString())
}