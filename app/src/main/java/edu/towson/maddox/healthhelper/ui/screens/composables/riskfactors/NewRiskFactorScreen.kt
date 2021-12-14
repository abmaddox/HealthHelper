package edu.towson.maddox.healthhelper.ui.screens.composables.riskfactors

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import edu.towson.maddox.healthhelper.ui.screens.composables.generics.FirstSubitemComposeMenu
import edu.towson.maddox.healthhelper.ui.screens.composables.generics.NewItemScreen
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.riskfactors.NewRiskFactorViewModel

@Composable
fun NewRiskFactorScreen (vm : NewRiskFactorViewModel,
                         onCancel : ()->Unit){
    NewItemScreen(vm = vm, onCancel =  onCancel ){
        FirstSubitemComposeMenu(vm = vm, itemType = "risk factors")
        Spacer(modifier = Modifier.padding(10.dp))
    }
}