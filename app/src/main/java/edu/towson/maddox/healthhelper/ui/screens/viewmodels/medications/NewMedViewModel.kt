package edu.towson.maddox.healthhelper.ui.screens.viewmodels.medications

import edu.towson.maddox.healthhelper.data.model.medications.*
import edu.towson.maddox.healthhelper.data.repo.HealthRepo
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.generics.NewItemViewModel


class NewMedViewModel(private val repo : HealthRepo, private val userId : Int) : NewItemViewModel<Medication, Frequency, AdministrationMethod, DoseUnit>()
{
    override suspend fun setSubItems1(): List<Medication>
    {
        return repo.getMedication()
    }

    override suspend fun setSubItems2(): List<Frequency>
    {
        return repo.getFrequencies()
    }

    override suspend fun setSubItems3(): List<AdministrationMethod>
    {
        return repo.getAdminMethods()
    }

    override suspend fun setSubItems4(): List<DoseUnit>
    {
        return repo.getDoseUnits()
    }

    override suspend fun addUserItem()
    {
        repo.insertUserMeds(uMedications(user_id = userId, medication_id = getSubItem1().medication_id, frequency_id = getSubItem2().frequency_id, method_id = getSubItem3().method_id, unit_id = getSubItem4().unit_id,getStartDate(),getEndDate(), reason = super.textEntry.value, dosage = super.numeric.value))
    }


}