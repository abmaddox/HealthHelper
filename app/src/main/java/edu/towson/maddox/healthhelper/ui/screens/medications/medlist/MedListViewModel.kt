package edu.towson.maddox.healthhelper.ui.screens.medications.medlist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.towson.maddox.healthhelper.data.model.medications.*
import edu.towson.maddox.healthhelper.db.HealthDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MedListViewModel(private val dao: HealthDAO, private val user_id : Int) : ViewModel() {
    private val _userMedications: MutableState<List<uMedications>> = mutableStateOf(listOf())
    val userMedications = _userMedications

    private val _medications: MutableState<List<Medication>> = mutableStateOf(listOf())
    val medications = _medications

    private val _frequencies: MutableState<List<Frequency>> = mutableStateOf(listOf())

    private val _methods: MutableState<List<AdministrationMethod>> = mutableStateOf(listOf())

    private val _units: MutableState<List<DoseUnit>> = mutableStateOf(listOf())

    init {
        viewModelScope.launch(Dispatchers.IO){
            _userMedications.value = dao.getUserMeds(user_id)
            _methods.value = dao.getAdminMethods()
            _medications.value = dao.getMedication()
            _frequencies.value = dao.getFrequencies()
            _units.value = dao.getDoseUnits()
        }
    }

    fun getMed(med_id : Int): Medication {
        return _medications.value.filter { it.medication_id == med_id }[0]
    }

    fun getFreq(frequencyId: Int): Frequency {
        return _frequencies.value.filter { it.frequency_id == frequencyId }[0]
    }

    fun getMethod(methodId: Int): AdministrationMethod {
        return _methods.value.filter { it.method_id == methodId }[0]
    }

    fun getUnit(unitId: Int): DoseUnit {
        return _units.value.filter { it.unit_id == unitId }[0]
    }
}