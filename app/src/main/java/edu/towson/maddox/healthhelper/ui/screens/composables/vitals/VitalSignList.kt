package edu.towson.maddox.healthhelper.ui.screens.composables.vitals

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import edu.towson.maddox.healthhelper.ui.components.FAB
import edu.towson.maddox.healthhelper.ui.screens.composables.generics.ItemList
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.vitals.VitalSignListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@ExperimentalFoundationApi
@Composable
fun VitalSignList(vm : VitalSignListViewModel,
                  onClickFAB : () -> Unit)
{
    ItemList(vm = vm, onDelete = { vm.deleteUserItem(it) }){
        FAB(onClick = onClickFAB)
    }
}