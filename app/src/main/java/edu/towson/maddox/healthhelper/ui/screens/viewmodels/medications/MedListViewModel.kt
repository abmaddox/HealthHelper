package edu.towson.maddox.healthhelper.ui.screens.viewmodels.medications

import androidx.lifecycle.viewModelScope
import edu.towson.maddox.healthhelper.data.model.medications.*
import edu.towson.maddox.healthhelper.data.repo.HealthRepo
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.generics.ItemListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class MedListViewModel(private val repo : HealthRepo) : ItemListViewModel<uMedications, Medication, Frequency, AdministrationMethod, DoseUnit>(repo)
{
    init
    {
        viewModelScope.launch { setItems() }
    }

    override fun setUserItems(): List<uMedications>
    {
        return repo.getUserMeds()
    }

    override fun setSubItems1(): List<Medication>
    {
        return repo.getMedication()
    }

    override fun setSubItems2(): List<Frequency> {
        return repo.getFrequencies()
    }

    override fun setSubItems3(): List<AdministrationMethod> {
        return repo.getAdminMethods()
    }

    override fun setSubItems4(): List<DoseUnit> {
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

    override suspend fun deleteUserItemFromDb(item: uMedications)
    {
        repo.deleteUserMeds(item)
    }

}