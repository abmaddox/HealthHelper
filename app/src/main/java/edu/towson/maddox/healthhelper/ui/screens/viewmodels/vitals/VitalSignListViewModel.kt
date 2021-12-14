package edu.towson.maddox.healthhelper.ui.screens.viewmodels.vitals

import androidx.lifecycle.viewModelScope
import edu.towson.maddox.healthhelper.data.model.vitals.RecordingMethod
import edu.towson.maddox.healthhelper.data.model.vitals.VitalSign
import edu.towson.maddox.healthhelper.data.model.vitals.uVitals
import edu.towson.maddox.healthhelper.data.repo.HealthRepo
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.generics.ItemListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class VitalSignListViewModel(private val repo : HealthRepo) : ItemListViewModel<uVitals, VitalSign, RecordingMethod, Int?, Int?>(repo)
{
    init
    {
        viewModelScope.launch { setItems() }
    }

    override fun setUserItems(): List<uVitals>
    {
        return repo.getUserVitals()
    }

    override fun setSubItems1(): List<VitalSign>
    {
        return repo.getVitalSigns()
    }

    override fun setSubItems2(): List<RecordingMethod>
    {
        return repo.getRecordingMethods()
    }

    override fun setSubItems3(): List<Int?>
    {
        return emptyList()
    }

    override fun setSubItems4(): List<Int?>
    {
        return emptyList()
    }

    override fun getSubItem1(subitem_id: Int): VitalSign
    {
        return subItems1.value.filter { subitem_id == it.vital_id }[0]
    }

    override fun getSubItem2(subitem_id: Int): RecordingMethod
    {
        return subItems2.value.filter { subitem_id == it.rMethod_id }[0]
    }

    override fun getSubItem3(subitem_id: Int): Int?
    {
        return null
    }

    override fun getSubItem4(subitem_id: Int): Int?
    {
        return null
    }

    override suspend fun deleteUserItemFromDb(item: uVitals)
    {
        repo.deleteUserVital(item)
    }
}