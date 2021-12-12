package edu.towson.maddox.healthhelper.ui.screens.viewmodels.conditions

import android.app.Application
import androidx.lifecycle.viewModelScope
import edu.towson.maddox.healthhelper.data.model.conditions.Condition
import edu.towson.maddox.healthhelper.data.model.conditions.uConditions
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.generics.NewItemViewModel
import kotlinx.coroutines.launch

class NewConditionViewModel(app : Application) : NewItemViewModel<Condition, Int?, Int?, Int?>(app)
{
    init
    {
        viewModelScope.launch { setItems() }
    }

    override suspend fun setSubItems1(): List<Condition>
    {
        return repo.getConditions() ?: listOf()
    }

    override suspend fun setSubItems2(): List<Int?> {
        return listOf()
    }

    override suspend fun setSubItems3(): List<Int?> {
        return listOf()
    }

    override suspend fun setSubItems4(): List<Int?> {
        return listOf()
    }

    override suspend fun addUserItem() {
        repo.insertUserConditions(uConditions(user_id = repo.returnUserId(), subItems1.value[selectedIndex1.value].condition_id,getStartDate(),getEndDate()))
    }
}