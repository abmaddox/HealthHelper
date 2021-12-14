package edu.towson.maddox.healthhelper.ui.screens.composables.medications

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import edu.towson.maddox.healthhelper.ui.components.BasicEntryField
import edu.towson.maddox.healthhelper.ui.components.StartEndDatePicker
import edu.towson.maddox.healthhelper.ui.screens.composables.generics.*
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.medications.NewMedViewModel


@Composable
fun NewMedicationScreen(vm : NewMedViewModel,
                        onCancel : ()->Unit){
    NewItemScreen(vm = vm, onCancel =  onCancel){
        FirstSubitemComposeMenu(vm = vm, itemType = "medications")

                Spacer(modifier = Modifier.padding(10.dp))
                SecondSubitemComposeMenu(vm = vm, itemType = "frequencies")
                Spacer(modifier = Modifier.padding(10.dp))
                ThirdSubitemComposeMenu(vm = vm, itemType = "administration methods")
                Spacer(modifier = Modifier.padding(10.dp))

                BasicEntryField(value = vm.numeric.value.toString(), setValue = {vm.updateNumeric(it)},
                label = "Dosage", keyboardType = KeyboardType.Number)
                Spacer(modifier = Modifier.padding(10.dp))
                FourthSubitemComposeMenu(vm = vm, itemType = "dosage units")

                Spacer(modifier = Modifier.padding(10.dp))
                StartEndDatePicker(vm = vm)
                Spacer(modifier = Modifier.padding(10.dp))
                BasicEntryField(value = vm.textEntry.value, setValue = {vm.updateTextEntry(it)}, label = "Reason for taking:",
                    keyboardType = KeyboardType.Text)
    }
}