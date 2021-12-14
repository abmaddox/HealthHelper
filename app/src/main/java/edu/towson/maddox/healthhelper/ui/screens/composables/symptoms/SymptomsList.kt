package edu.towson.maddox.healthhelper.ui.screens.composables.symptoms

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import edu.towson.maddox.healthhelper.ui.components.FAB
import edu.towson.maddox.healthhelper.ui.components.ItemTypes
import edu.towson.maddox.healthhelper.ui.screens.composables.generics.ItemList
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.symptoms.SymptomsListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalFoundationApi
@ExperimentalCoroutinesApi
@Composable
fun SymptomsList(vm : SymptomsListViewModel,
                 onClickFAB : () -> Unit)
{
    ItemList(listType = "Symptoms", vm = vm, onDelete = { vm.deleteUserItem(it) },
        fab = { FAB(onClick = onClickFAB) },
        itemTypes = ItemTypes.us)
}
