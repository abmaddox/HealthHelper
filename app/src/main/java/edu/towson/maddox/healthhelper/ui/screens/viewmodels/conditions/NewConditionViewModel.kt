package edu.towson.maddox.healthhelper.ui.screens.viewmodels.conditions

import androidx.lifecycle.viewModelScope
import edu.towson.maddox.healthhelper.data.model.conditions.Condition
import edu.towson.maddox.healthhelper.data.model.conditions.uConditions
import edu.towson.maddox.healthhelper.data.repo.HealthRepo
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.generics.NewItemViewModel
import kotlinx.coroutines.launch

class NewConditionViewModel(private val repo : HealthRepo) : NewItemViewModel<Condition, Int?, Int?, Int?>()
{
    init
    {
        viewModelScope.launch { setItems() }
    }

    override fun setSubItems1(): List<Condition>
    {
        return repo.getConditions()
    }

    override fun setSubItems2(): List<Int?> {
        return listOf()
    }

    override fun setSubItems3(): List<Int?> {
        return listOf()
    }

    override fun setSubItems4(): List<Int?> {
        return listOf()
    }

    override fun addUserItem() {
        if (selectedIndex1.value == null || getStartDate()=="")
        {
            toggleErrorPopupVisible()
            throw Exception("error")
        }
        else
        {
            val item = uConditions(
                user_id = repo.returnUserId(),
                subItems1.value[selectedIndex1.value!!].condition_id,
                getStartDate(),
                getEndDate()
            )
            repo.addUserConditions(item)

            viewModelScope.launch {
                repo.insertUserConditions(item)
                repo.setUserConditions()
            }
        }

    }
}