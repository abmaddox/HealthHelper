package edu.towson.maddox.healthhelper.ui.screens.composables.symptoms

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import edu.towson.maddox.healthhelper.ui.components.FAB
import edu.towson.maddox.healthhelper.ui.screens.composables.generics.ItemList
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.symptoms.SymptomsListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalFoundationApi
@ExperimentalCoroutinesApi
@Composable
fun SymptomsList(vm : SymptomsListViewModel,
                 onClickFAB : () -> Unit)
{
    ItemList(vm = vm, onDelete = { vm.deleteUserItem(it) }, listType = "Symptoms"){
        FAB(onClick = onClickFAB)
    }
}
