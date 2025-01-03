package edu.towson.maddox.healthhelper.ui.screens.composables.medications

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import edu.towson.maddox.healthhelper.ui.components.FAB
import edu.towson.maddox.healthhelper.ui.components.ItemTypes
import edu.towson.maddox.healthhelper.ui.screens.composables.generics.ItemList
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.medications.MedListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalFoundationApi
@ExperimentalCoroutinesApi
@Composable
fun MedicationList(vm : MedListViewModel,
                   onClickFAB : () -> Unit)
{
    ItemList(
        listType = ItemTypes.umed.toString(),
        vm = vm,
        onDelete = { vm.deleteUserItem(it) },
        fab = {
            FAB(onClick = onClickFAB)
        },
        itemTypes = ItemTypes.umed
    )
}