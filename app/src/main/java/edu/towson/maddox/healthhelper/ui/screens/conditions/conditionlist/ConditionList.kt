package edu.towson.maddox.healthhelper.ui.screens.conditions.conditionlist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
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
        LazyColumn{
            itemsIndexed(vm.userConditions.value){
                    _, ucond ->
                UConditionRow(
                    cond = vm.getCond(ucond.condition_id),
                    uConditions =ucond,
                    onDelete = onDelete
                )
            }
        }
    }
}