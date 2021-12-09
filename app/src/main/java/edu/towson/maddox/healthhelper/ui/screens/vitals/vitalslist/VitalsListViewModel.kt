package edu.towson.maddox.healthhelper.ui.screens.vitals.vitalslist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.towson.maddox.healthhelper.data.model.conditions.Condition
import edu.towson.maddox.healthhelper.data.model.conditions.uConditions
import edu.towson.maddox.healthhelper.data.model.vitals.RecordingMethod
import edu.towson.maddox.healthhelper.data.model.vitals.VitalSign
import edu.towson.maddox.healthhelper.data.model.vitals.uVitals
import edu.towson.maddox.healthhelper.data.repo.HealthRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VitalsListViewModel(private val repo: HealthRepo, private val user_id : Int) : ViewModel() {
    private val _userVitals: MutableState<List<uVitals>> = mutableStateOf(listOf())
    val userVitals = _userVitals

    private val _vitals: MutableState<List<VitalSign>> = mutableStateOf(listOf())
    val vitals = _vitals

    private val _methods: MutableState<List<RecordingMethod>> = mutableStateOf(listOf())
    val methods = _methods

    init {
        viewModelScope.launch(Dispatchers.IO){
            _userVitals.value = repo.getUserVitals(user_id)
            _methods.value = repo.getRecordingMethods()
        }
    }
    fun getVital(vital_id : Int): VitalSign {
        return _vitals.value.filter { it.vital_id == vital_id }[0]
    }

    fun getMethod(method_id : Int): String {
        return _methods.value.filter { it.rMethod_id == method_id }[0].toString()
    }
}