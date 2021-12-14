package edu.towson.maddox.healthhelper.ui.screens.composables.riskfactors

import androidx.compose.runtime.Composable
import edu.towson.maddox.healthhelper.data.model.riskFactors.uRiskFactors
import edu.towson.maddox.healthhelper.ui.components.Header
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.riskfactors.RiskFactorsListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Composable
fun RiskFactorRow(vm: RiskFactorsListViewModel, item: uRiskFactors){
    Header(text = vm.getSubItem1(item.factor_id).toString())
}