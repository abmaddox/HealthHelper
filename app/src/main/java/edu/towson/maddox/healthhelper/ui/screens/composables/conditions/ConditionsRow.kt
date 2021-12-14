package edu.towson.maddox.healthhelper.ui.screens.composables.conditions

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import edu.towson.maddox.healthhelper.data.model.conditions.uConditions
import edu.towson.maddox.healthhelper.ui.components.Header
import edu.towson.maddox.healthhelper.ui.screens.composables.generics.StartAndEndDateText
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.conditions.ConditionListViewModel

@Composable
fun ConditionRow(vm : ConditionListViewModel,
                 item : uConditions){
    Header(text = vm.getSubItem1(item.condition_id).conditionName)
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth())
    {
        StartAndEndDateText(item)
    }
}