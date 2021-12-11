package edu.towson.maddox.healthhelper.ui.screens.composables.conditions

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import edu.towson.maddox.healthhelper.ui.components.FAB
import edu.towson.maddox.healthhelper.ui.screens.composables.generics.ItemList
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.conditions.ConditionListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalFoundationApi
@ExperimentalCoroutinesApi
@Composable
fun ConditionList(vm : ConditionListViewModel,
                  onClickFAB : () -> Unit)
{
    ItemList(vm = vm, onDelete = { vm.deleteUserItem(it) }){
        FAB(onClick = onClickFAB)
    }
}