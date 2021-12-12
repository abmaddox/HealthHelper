package edu.towson.maddox.healthhelper.ui.screens.viewmodels.medications

import android.app.Application
import androidx.lifecycle.viewModelScope
import edu.towson.maddox.healthhelper.data.model.medications.*
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.generics.NewItemViewModel
import kotlinx.coroutines.launch


class NewMedViewModel(app : Application) : NewItemViewModel<Medication, Frequency, AdministrationMethod, DoseUnit>(app)
{
    init
    {
        viewModelScope.launch { setItems() }
    }

    override suspend fun setSubItems1(): List<Medication>
    {
        return repo.getMedication() ?: listOf()
    }

    override suspend fun setSubItems2(): List<Frequency>
    {
        return repo.getFrequencies() ?: listOf()
    }

    override suspend fun setSubItems3(): List<AdministrationMethod>
    {
        return repo.getAdminMethods() ?: listOf()
    }

    override suspend fun setSubItems4(): List<DoseUnit>
    {
        return repo.getDoseUnits() ?: listOf()
    }

    override suspend fun addUserItem()
    {
        repo.insertUserMeds(uMedications(user_id = repo.returnUserId(), medication_id = getSubItem1().medication_id, frequency_id = getSubItem2().frequency_id, method_id = getSubItem3().method_id, unit_id = getSubItem4().unit_id,getStartDate(),getEndDate(), reason = super.textEntry.value, dosage = super.numeric.value))
    }


}