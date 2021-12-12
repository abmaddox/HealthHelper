package edu.towson.maddox.healthhelper.ui.screens.viewmodels.medications

import android.app.Application
import androidx.lifecycle.viewModelScope
import edu.towson.maddox.healthhelper.data.model.medications.*
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.generics.ItemListViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class MedListViewModel(app : Application) : ItemListViewModel<uMedications, Medication, Frequency, AdministrationMethod, DoseUnit>(app)
{
    init
    {
        viewModelScope.launch { setItems() }
    }

    override suspend fun setUserItems(): List<uMedications>
    {
        return repo.getUserMeds() ?: listOf()
    }

    override suspend fun setSubItems1(): List<Medication>
    {
        return repo.getMedication() ?: listOf()
    }

    override suspend fun setSubItems2(): List<Frequency> {
        return repo.getFrequencies() ?: listOf()
    }

    override suspend fun setSubItems3(): List<AdministrationMethod> {
        return repo.getAdminMethods() ?: listOf()
    }

    override suspend fun setSubItems4(): List<DoseUnit> {
        return repo.getDoseUnits() ?: listOf()
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

    override fun deleteUserItem(item: uMedications)
    {
        viewModelScope.launch(Dispatchers.IO){
            repo.deleteUserMeds(item)
            reloadUserItems()
        }
    }

}