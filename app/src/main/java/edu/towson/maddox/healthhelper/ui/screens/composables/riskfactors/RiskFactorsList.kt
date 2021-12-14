package edu.towson.maddox.healthhelper.ui.screens.composables.riskfactors

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import edu.towson.maddox.healthhelper.ui.components.FAB
import edu.towson.maddox.healthhelper.ui.components.ItemTypes
import edu.towson.maddox.healthhelper.ui.screens.composables.generics.ItemList
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.riskfactors.RiskFactorsListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalFoundationApi
@ExperimentalCoroutinesApi
@Composable
fun RiskFactorsList(vm : RiskFactorsListViewModel,
                    onClickFAB : () -> Unit)
{
    ItemList(vm = vm, onDelete = { vm.deleteUserItem(it) }, listType = ItemTypes.urf.toString(), itemTypes = ItemTypes.urf){
        FAB(onClick = onClickFAB)
    }
}