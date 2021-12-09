package edu.towson.maddox.healthhelper.ui.screens.conditions.newcondition

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import edu.towson.maddox.healthhelper.data.model.conditions.uConditions
import edu.towson.maddox.healthhelper.data.model.symptoms.Symptom
import edu.towson.maddox.healthhelper.ui.components.ComposeMenu
import edu.towson.maddox.healthhelper.ui.components.ItemTypes
import edu.towson.maddox.healthhelper.ui.components.NewItemScreen
import edu.towson.maddox.healthhelper.ui.screens.conditions.conditionslist.ConditionListViewModel

@Composable
fun NewCondition(vm : NewConditionViewModel,
    onAddCondition: (uConditions) -> Unit,
    onCancel: () -> Unit
    ) {
    NewItemScreen(itemType = ItemTypes.uc, vm = vm, ConfirmAddAndCancelSlot = {
        Row(modifier = Modifier.fillMaxWidth() ,horizontalArrangement = Arrangement.SpaceEvenly ) {
            Button(onClick = { onAddCondition }) {
                
            }
        }
    } )
}