package edu.towson.maddox.healthhelper.ui.screens.composables.generics

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import edu.towson.maddox.healthhelper.ui.components.Header
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.generics.IItemListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalFoundationApi
@ExperimentalCoroutinesApi
@Composable
fun <A,B,C,D,E>ItemList(
    listType : String,
    vm: IItemListViewModel<A, B, C, D, E>,
    onDelete: (A) -> Unit,
    fab: @Composable () -> Unit = {}
){
    Scaffold(
        floatingActionButton = fab,
        floatingActionButtonPosition = FabPosition.End,
        isFloatingActionButtonDocked = true
    ) {
        Header(text = listType)
        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()) {
            itemsIndexed(vm.userItems.value) { _, item ->
                    ItemRow(
                        vm = vm,
                        onDelete = {onDelete(item)},
                        item = item
                    )
            }
        }
    }
}