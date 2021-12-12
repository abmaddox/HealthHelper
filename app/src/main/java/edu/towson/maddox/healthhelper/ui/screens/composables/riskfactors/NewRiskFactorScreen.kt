package edu.towson.maddox.healthhelper.ui.screens.composables.riskfactors

import androidx.compose.runtime.Composable
import edu.towson.maddox.healthhelper.ui.components.ItemTypes
import edu.towson.maddox.healthhelper.ui.screens.composables.generics.NewItemScreen
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.riskfactors.NewRiskFactorViewModel

@Composable
fun NewRiskFactorScreen (vm : NewRiskFactorViewModel,
                         onCancel : ()->Unit){
    NewItemScreen(itemType = ItemTypes.urf, vm = vm, onCancel = onCancel, recordType = ItemTypes.nurf.toString())
}