package edu.towson.maddox.healthhelper.ui.screens.viewmodels.symptoms

import androidx.lifecycle.viewModelScope
import edu.towson.maddox.healthhelper.data.model.symptoms.Symptom
import edu.towson.maddox.healthhelper.data.model.symptoms.uSymptoms
import edu.towson.maddox.healthhelper.data.repo.HealthRepo
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.generics.ItemListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class SymptomsListViewModel(private val repo : HealthRepo) : ItemListViewModel <uSymptoms, Symptom, Int?, Int?, Int?>(repo)
{
    init
    {
        viewModelScope.launch { setItems() }
    }

    override fun setUserItems(): List<uSymptoms>
    {
        return repo.getUserSymptoms()
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

    override fun getSubItem1(subitem_id: Int): Symptom
    {
       return subItems1.value.filter { subitem_id == it.symptom_id }[0]
    }

    override fun getSubItem2(subitem_id: Int): Int?
    {
        return null
    }

    override fun getSubItem3(subitem_id: Int): Int?
    {
        return null
    }

    override fun getSubItem4(subitem_id: Int): Int?
    {
        return null
    }

    override suspend fun deleteUserItemFromDb(item: uSymptoms)
    {
        repo.deleteUserSymptoms(item)
    }
}