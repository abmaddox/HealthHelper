package edu.towson.maddox.healthhelper.ui.screens.medications.newmed

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import edu.towson.maddox.healthhelper.data.model.medications.uMedications

@ExperimentalComposeUiApi
@Composable
fun NewMedView(
    vm: NewMedViewModel = viewModel(),
    onAddMed: (uMedications) -> Unit,
    onCancel: () -> Unit
) {
    Column(modifier = Modifier.padding(15.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top) {
        Text(text = "New Medication", fontSize = 20.sp)
    }

}
