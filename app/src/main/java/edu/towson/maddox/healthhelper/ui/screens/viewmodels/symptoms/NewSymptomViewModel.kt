package edu.towson.maddox.healthhelper.ui.screens.viewmodels.symptoms

import androidx.lifecycle.viewModelScope
import edu.towson.maddox.healthhelper.data.model.symptoms.Symptom
import edu.towson.maddox.healthhelper.data.model.symptoms.uSymptoms
import edu.towson.maddox.healthhelper.data.repo.HealthRepo
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.generics.NewItemViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewSymptomViewModel(private val repo : HealthRepo, private val userId : Int) : NewItemViewModel<Symptom, Int?, Int?, Int?>()
{
    override suspend fun setSubItems1(): List<Symptom>
    {
        return repo.getSymptoms()
    }

    override suspend fun setSubItems2(): List<Int?>
    {
        return listOf()
    }

    override suspend fun setSubItems3(): List<Int?>
    {
        return listOf()
    }

    override suspend fun setSubItems4(): List<Int?>
    {
        return listOf()
    }

    override suspend fun addUserItem()
    {
        viewModelScope.launch(Dispatchers.IO){
            repo.insertUserSymptoms(uSymptoms(user_id = userId, symptom_id = getSubItem1().symptom_id, startDate = getStartDate(), endDate = getEndDate()))
        }
    }
}