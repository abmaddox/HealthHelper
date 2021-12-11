package edu.towson.maddox.healthhelper.ui.screens.viewmodels.conditions

import androidx.lifecycle.viewModelScope
import edu.towson.maddox.healthhelper.data.model.conditions.Condition
import edu.towson.maddox.healthhelper.data.model.conditions.uConditions
import edu.towson.maddox.healthhelper.data.repo.HealthRepo
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.generics.ItemListViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class ConditionListViewModel(private val repo : HealthRepo, private val user_id : Int) : ItemListViewModel<uConditions, Condition, Int?, Int?, Int?>()
{

    override suspend fun setUserItems(): List<uConditions> {
        return repo.getUserConditions(user_id)
    }

    override suspend fun setSubItems1(): List<Condition> {
        return repo.getConditions()
    }

    override suspend fun setSubItems2(): List<Int?> {return listOf()}

    override suspend fun setSubItems3(): List<Int?> {return listOf()}

    override suspend fun setSubItems4(): List<Int?> {return listOf()}

    override fun getSubItem1(subitem_id : Int): Condition {
       return subItems1.value.filter { subitem_id == it.condition_id }[0]
    }

    override fun getSubItem2(subitem_id : Int): Int? {
        return null
    }

    override fun getSubItem3(subitem_id : Int): Int? {
        return null
    }

    override fun getSubItem4(subitem_id : Int): Int? {
        return null
    }

    override fun deleteUserItem(item: uConditions)
    {
        viewModelScope.launch(Dispatchers.IO) {
            repo.deleteUserConditions(item)
            reloadUserItems()
        }
    }
}