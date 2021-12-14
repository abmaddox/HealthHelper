package edu.towson.maddox.healthhelper.ui.screens.viewmodels.conditions

import androidx.lifecycle.viewModelScope
import edu.towson.maddox.healthhelper.data.model.conditions.Condition
import edu.towson.maddox.healthhelper.data.model.conditions.uConditions
import edu.towson.maddox.healthhelper.data.repo.HealthRepo
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.generics.ItemListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class ConditionListViewModel(private val repo : HealthRepo) : ItemListViewModel<uConditions, Condition, Int?, Int?, Int?>(repo = repo)
{
    init
    {
        viewModelScope.launch { setItems() }
    }

    override fun setUserItems() : List<uConditions>
    {
        return repo.getUserConditions()
    }

    override fun setSubItems1() : List<Condition>
    {
        return repo.getConditions()
    }

    override fun setSubItems2() : List<Int?> {return listOf()}

    override fun setSubItems3() : List<Int?> {return listOf()}

    override fun setSubItems4() : List<Int?> {return listOf()}

    override fun getSubItem1(subitem_id : Int): Condition
    {
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

    override suspend fun deleteUserItemFromDb(item: uConditions)
    {
        repo.deleteUserConditions(item)
    }

}