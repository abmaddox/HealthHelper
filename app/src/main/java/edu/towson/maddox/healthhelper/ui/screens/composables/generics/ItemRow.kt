package edu.towson.maddox.healthhelper.ui.screens.composables.generics

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import edu.towson.maddox.healthhelper.data.model.conditions.uConditions
import edu.towson.maddox.healthhelper.data.model.medications.uMedications
import edu.towson.maddox.healthhelper.data.model.riskFactors.uRiskFactors
import edu.towson.maddox.healthhelper.data.model.symptoms.uSymptoms
import edu.towson.maddox.healthhelper.data.model.vitals.uVitals
import edu.towson.maddox.healthhelper.ui.screens.composables.conditions.ConditionRow
import edu.towson.maddox.healthhelper.ui.screens.composables.medications.MedicationRow
import edu.towson.maddox.healthhelper.ui.screens.composables.riskfactors.RiskFactorRow
import edu.towson.maddox.healthhelper.ui.screens.composables.symptoms.SymptomsRow
import edu.towson.maddox.healthhelper.ui.screens.composables.vitals.VitalRow
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.conditions.ConditionListViewModel
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.generics.IItemListViewModel
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.medications.MedListViewModel
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.riskfactors.RiskFactorsListViewModel
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.symptoms.SymptomsListViewModel
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.vitals.VitalSignListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@ExperimentalFoundationApi
@Composable
fun <A,B,C,D,E> ItemRow(
    idx : Int,
    vm: IItemListViewModel<A, B, C, D, E>,
    item: A,
    onDelete: (Int) -> Unit
){
    Card(
        shape = RoundedCornerShape(5.dp),
        elevation = 16.dp,
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 5.dp, bottom = 5.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .combinedClickable(
                    onLongClick = {
                        onDelete(idx)
                    }
                ) {}
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

// Type specific information
            when (item){
                (item is uConditions) -> ConditionRow(item = item as uConditions, vm = vm as ConditionListViewModel)
                (item is uVitals) -> VitalRow(item = item as uVitals,vm = vm as VitalSignListViewModel)
                (item is uSymptoms) -> SymptomsRow(item = item as uSymptoms,vm = vm as SymptomsListViewModel)
                (item is uRiskFactors) -> RiskFactorRow(item = item as uRiskFactors, vm = vm as RiskFactorsListViewModel)
                (item is uMedications) -> MedicationRow(item = item as uMedications,vm = vm as MedListViewModel)
            }
        }
    }
}

@Composable
fun StartAndEndDateText(
    uConditions: uConditions? = null,
    uMedications: uMedications? = null,
    uSymptoms: uSymptoms? = null
){
    Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
        if (uConditions != null){
            Text(text = "Start Date: ${uConditions.startDate}", Modifier.padding(end = 5.dp))
            Text(text = "End Date: ${uConditions.endDate}", Modifier.padding(end = 5.dp))
        }
        if (uMedications != null){
            Text(text = "Start Date: ${uMedications.startDate}", Modifier.padding(end = 5.dp))
            Text(text = "End Date: ${uMedications.endDate}", Modifier.padding(end = 5.dp))
        }
        if (uSymptoms != null){
            Text(text = "Start Date: ${uSymptoms.startDate}", Modifier.padding(end = 5.dp))
            Text(text = "End Date: ${uSymptoms.endDate}", Modifier.padding(end = 5.dp))
        }
    }
}