package edu.towson.maddox.healthhelper.ui.screens.composables.generics

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.towson.maddox.healthhelper.ui.components.Header
import edu.towson.maddox.healthhelper.ui.components.ItemTypes
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.generics.IItemListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalFoundationApi
@ExperimentalCoroutinesApi
@Composable
fun <A,B,C,D,E>ItemList(
    listType: String,
    vm: IItemListViewModel<A, B, C, D, E>,
    itemTypes: ItemTypes,
    onDelete: (Int) -> Unit,
    fab: @Composable () -> Unit = {},
){
    Scaffold(
        floatingActionButton = fab,
        floatingActionButtonPosition = FabPosition.End,
        isFloatingActionButtonDocked = true
    ) {
        Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center) {
            Header(text = listType)
        }
        Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.padding(25.dp))
            if (vm.userItems.value.isNotEmpty())
            {
                LazyColumn( contentPadding = PaddingValues(5.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    itemsIndexed(vm.userItems.value) { idx, item ->
                        ItemRow(
                            idx = idx,
                            vm = vm,
                            onDelete = { i -> onDelete(i) },
                            item = item,
                            itemTypes = itemTypes
                        )
                    }
                }
            }
            else{
                Text(text = "Add items using the + button in the bottom right.", fontSize = 25.sp, modifier = Modifier.padding(15.dp))
            }
        }
    }
}