package edu.towson.maddox.healthhelper.ui.screens.viewmodels.symptoms

import android.app.Application
import androidx.lifecycle.viewModelScope
import edu.towson.maddox.healthhelper.data.model.symptoms.Symptom
import edu.towson.maddox.healthhelper.data.model.symptoms.uSymptoms
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.generics.NewItemViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewSymptomViewModel(app : Application) : NewItemViewModel<Symptom, Int?, Int?, Int?>(app)
{
    init
    {
        viewModelScope.launch { setItems() }
    }

    override suspend fun setSubItems1(): List<Symptom>
    {
        return repo.getSymptoms() ?: listOf()
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
            repo.insertUserSymptoms(uSymptoms(user_id = repo.returnUserId(), symptom_id = getSubItem1().symptom_id, startDate = getStartDate(), endDate = getEndDate()))
        }
    }
}