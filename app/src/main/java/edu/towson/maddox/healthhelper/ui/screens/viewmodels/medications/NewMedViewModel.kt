package edu.towson.maddox.healthhelper.ui.screens.viewmodels.medications

import androidx.lifecycle.viewModelScope
import edu.towson.maddox.healthhelper.data.model.medications.*
import edu.towson.maddox.healthhelper.data.repo.HealthRepo
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.generics.NewItemViewModel
import kotlinx.coroutines.launch


class NewMedViewModel(private val repo : HealthRepo) : NewItemViewModel<Medication, Frequency, AdministrationMethod, DoseUnit>()
{
    init
    {
        viewModelScope.launch { setItems() }
    }

    override fun setSubItems1(): List<Medication>
    {
        return repo.getMedication()
    }

    override fun setSubItems2(): List<Frequency>
    {
        return repo.getFrequencies()
    }

    override fun setSubItems3(): List<AdministrationMethod>
    {
        return repo.getAdminMethods()
    }

    override fun setSubItems4(): List<DoseUnit>
    {
        return repo.getDoseUnits()
    }

    override fun addUserItem()
    {
        if (numeric.value<=0.0)
        {
            toggleErrorPopupVisible()
            throw Exception("error")
        }
        else if (selectedIndex1.value==1 || selectedIndex2.value==1 || selectedIndex3.value==1 || selectedIndex4.value==1 || getStartDate()=="2010-1-1" || getEndDate()=="2011-1-1")
        {
            toggleNoChangePopupVisible()
            throw Exception("error")
        }
        else{
            proceedToAddUserItem()
        }
    }

    override fun proceedToAddUserItem()
    {
        val item = uMedications(user_id = repo.returnUserId(), medication_id = getSubItem1().medication_id, frequency_id = getSubItem2().frequency_id, method_id = getSubItem3().method_id, unit_id = getSubItem4().unit_id,getStartDate(),getEndDate(), reason = super.textEntry.value, dosage = super.numeric.value)
        repo.addUserMeds(item)
        viewModelScope.launch {
            repo.insertUserMeds(item)
            repo.setUserMeds()
        }
    }
}