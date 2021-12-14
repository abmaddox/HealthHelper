package edu.towson.maddox.healthhelper.ui.screens.composables.symptoms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import edu.towson.maddox.healthhelper.data.model.symptoms.uSymptoms
import edu.towson.maddox.healthhelper.ui.components.Header
import edu.towson.maddox.healthhelper.ui.screens.composables.generics.StartAndEndDateText
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.symptoms.SymptomsListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Composable
fun SymptomsRow(vm : SymptomsListViewModel, item : uSymptoms){
    Header(text = vm.getSubItem1(item.symptom_id).symptomName)
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth())
    {
        StartAndEndDateText(uSymptoms = item)
    }
}