package edu.towson.maddox.healthhelper.ui.screens.conditions.conditionslist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import edu.towson.maddox.healthhelper.data.model.conditions.uConditions

@ExperimentalFoundationApi
@Composable
fun ConditionList(onDelete: (uConditions) -> Unit,
                  vm : ConditionListViewModel,
                  fab : @Composable () -> Unit = {}){
        Scaffold(
            floatingActionButton = fab,
            floatingActionButtonPosition = FabPosition.End,
            isFloatingActionButtonDocked = true
        ) {
            LazyColumn(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()) {
                itemsIndexed(vm.userItems.value) { _, ucond ->
                    UConditionRow(
                        cond = vm.getSubItem1(ucond.condition_id),
                        uConditions = ucond,
                        onDelete = onDelete
                    )
                }
            }
        }
    }