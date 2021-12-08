package edu.towson.maddox.healthhelper.ui.screens.medications.newmed

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.lifecycle.viewmodel.compose.viewModel
import edu.towson.maddox.healthhelper.data.model.medications.uMedications

@ExperimentalComposeUiApi
@Composable
fun NewMedView(
    vm: NewMedViewModel = viewModel(),
    onAddMed: (uMedications) -> Unit
) {

}
