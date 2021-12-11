package edu.towson.maddox.healthhelper.ui.screens.composables.generics

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
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
import edu.towson.maddox.healthhelper.ui.components.Header
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
    vm: IItemListViewModel<A, B, C, D, E>,
    item: A,
    onDelete: () -> Unit
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
                        onDelete()
                    }
                ) {}
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

// Type specific information
            when (item){
                (item is uConditions) -> ConditionRowContent(uc = item as uConditions, vm as ConditionListViewModel)
                (item is uVitals) -> VitalRowContent(uv = item as uVitals, vm as VitalSignListViewModel)
                (item is uSymptoms) -> SymptomRowContent(us = item as uSymptoms, vm as SymptomsListViewModel)
                (item is uRiskFactors) -> RiskFactorRowContent(urf = item as uRiskFactors, vm as RiskFactorsListViewModel)
                (item is uMedications) -> MedicationRowContent(umed = item as uMedications, vm as MedListViewModel)
            }
        }
    }
}

@ExperimentalCoroutinesApi
@Composable
fun ConditionRowContent(uc : uConditions, vm: ConditionListViewModel)
{
    Header(text = vm.getSubItem1(uc.condition_id).conditionName)
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth())
    {
        StartAndEndDateText(uc)
    }
}

@ExperimentalCoroutinesApi
@Composable
fun VitalRowContent(uv: uVitals, vm: VitalSignListViewModel){
    Header(text = vm.getSubItem1(uv.vital_id).type)
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth())
    {
        Text(text = "Measurement: ${uv.measurement} ${vm.getSubItem1(uv.vital_id).unit}")
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth())
    {
        Text(text = "Recording Method: ${vm.subItems2}")
        Text(text = "Recorded At: ${uv.timestamp}")
    }
}

@ExperimentalCoroutinesApi
@Composable
fun RiskFactorRowContent(urf: uRiskFactors, vm: RiskFactorsListViewModel){
    Header(text = vm.getSubItem1(urf.factor_id).toString())
}

@ExperimentalCoroutinesApi
@Composable
fun SymptomRowContent(us: uSymptoms, vm: SymptomsListViewModel)
{
    Header(text = vm.getSubItem1(us.symptom_id).symptomName)
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth())
    {
        StartAndEndDateText(uSymptoms = us)
    }
}

@ExperimentalCoroutinesApi
@Composable
fun MedicationRowContent(umed: uMedications, vm: MedListViewModel){
    Header(text = vm.getSubItem1(umed.medication_id).toString() + "Dosage: ${umed.dosage} ${vm.getSubItem4(umed.unit_id)}")
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth())
    {
        Text(text = "Frequency : ${vm.getSubItem2(umed.frequency_id)}")
        Text(text = "Administration Method: ${vm.getSubItem3(umed.method_id)}")
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth())
    {
        StartAndEndDateText(uMedications = umed)
        Text(text = "Reason For Taking : ${umed.reason}")
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