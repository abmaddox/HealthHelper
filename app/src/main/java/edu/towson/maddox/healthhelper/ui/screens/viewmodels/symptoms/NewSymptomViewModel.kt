package edu.towson.maddox.healthhelper.ui.screens.viewmodels.symptoms

import androidx.lifecycle.viewModelScope
import edu.towson.maddox.healthhelper.data.model.symptoms.Symptom
import edu.towson.maddox.healthhelper.data.model.symptoms.uSymptoms
import edu.towson.maddox.healthhelper.data.repo.HealthRepo
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.generics.NewItemViewModel
import kotlinx.coroutines.launch

class NewSymptomViewModel(private val repo : HealthRepo) : NewItemViewModel<Symptom, Int?, Int?, Int?>()
{
    init
    {
        viewModelScope.launch { setItems() }
    }

    override fun setSubItems1(): List<Symptom>
    {
        return repo.getSymptoms()
    }

    override fun setSubItems2(): List<Int?>
    {
        return listOf()
    }

    override fun setSubItems3(): List<Int?>
    {
        return listOf()
    }

    override fun setSubItems4(): List<Int?>
    {
        return listOf()
    }

    override fun addUserItem()
    {
        if (selectedIndex1.value == null || getStartDate()=="")
        {
            toggleErrorPopupVisible()
            throw Exception("error")
        }
        else
        {
            val item = uSymptoms(user_id = repo.returnUserId(), symptom_id = getSubItem1().symptom_id, startDate = getStartDate(), endDate = getEndDate())
            repo.addUserSymptoms(item)
            viewModelScope.launch {
                repo.insertUserSymptoms(item)
                repo.setUserSymptoms()
            }
        }
    }
}