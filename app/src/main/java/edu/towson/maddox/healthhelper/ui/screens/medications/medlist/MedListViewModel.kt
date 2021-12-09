package edu.towson.maddox.healthhelper.ui.screens.medications.medlist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.towson.maddox.healthhelper.data.model.medications.*
import edu.towson.maddox.healthhelper.data.model.vm.ItemListViewModel
import edu.towson.maddox.healthhelper.data.repo.HealthRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MedListViewModel(private val repo: HealthRepo, private val user_id : Int) :
    ItemListViewModel<uMedications, Medication, Frequency, AdministrationMethod, DoseUnit>(repo, user_id) {
    override suspend fun setUserItems(): List<uMedications> {
        return repo.getUserMeds(user_id)
    }

    override suspend fun setSubItems1(): List<Medication> {
        return repo.getMedication()
    }

    override suspend fun setSubItems2(): List<Frequency> {
        return repo.getFrequencies()
    }

    override suspend fun setSubItems3(): List<AdministrationMethod> {
        return repo.getAdminMethods()
    }

    override suspend fun setSubItems4(): List<DoseUnit> {
        return repo.getDoseUnits()
    }

    override fun getSubItem1(subitem_id: Int): Medication {
        return subItems1.value.filter { it.medication_id == subitem_id }[0]
    }

    override fun getSubItem2(subitem_id: Int): Frequency {
        return subItems2.value.filter { it.frequency_id == subitem_id }[0]
    }

    override fun getSubItem3(subitem_id: Int): AdministrationMethod {
        return subItems3.value.filter { it.method_id == subitem_id }[0]
    }

    override fun getSubItem4(subitem_id: Int): DoseUnit {
        return subItems4.value.filter { it.unit_id == subitem_id }[0]
    }

}