package edu.towson.maddox.healthhelper.ui.screens.vitals.newvital

import androidx.compose.runtime.MutableState
import androidx.lifecycle.viewModelScope
import edu.towson.maddox.healthhelper.data.model.vitals.RecordingMethod
import edu.towson.maddox.healthhelper.data.model.vitals.VitalSign
import edu.towson.maddox.healthhelper.data.model.vitals.uVitals
import edu.towson.maddox.healthhelper.data.model.vm.NewItemViewModel
import edu.towson.maddox.healthhelper.data.repo.HealthRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class NewVitalSignViewModel(private val repo : HealthRepo, private val user_id : Int) : NewItemViewModel<VitalSign, RecordingMethod, Int?, Int?>(repo, user_id = user_id) {
    override suspend fun setSubItems1(): List<VitalSign> {
        return viewModelScope.async(Dispatchers.IO){
            repo.getVitalSigns()
        }.await()
    }

    override suspend fun setSubItems2(): List<RecordingMethod> {
        return viewModelScope.async(Dispatchers.IO){
            repo.getRecordingMethods()
        }.await()
    }

    override suspend fun setSubItems3(): List<Int?> {
       return listOf()
    }

    override suspend fun setSubItems4(): List<Int?> {
        return listOf()
    }

    override suspend fun addUserItem() {
        viewModelScope.launch(Dispatchers.IO)
        {
            repo.insertUserVital(
                uVitals(
                    user_id,
                    subItems1.value[selectedIndex1.value].vital_id,
                    subItems2.value[selectedIndex2.value].rMethod_id,
                    measurement = numeric.value
                )
            )
        }
    }
}