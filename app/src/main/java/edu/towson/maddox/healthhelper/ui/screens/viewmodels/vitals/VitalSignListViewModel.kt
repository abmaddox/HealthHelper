package edu.towson.maddox.healthhelper.ui.screens.viewmodels.vitals

import android.app.Application
import androidx.lifecycle.viewModelScope
import edu.towson.maddox.healthhelper.data.model.vitals.RecordingMethod
import edu.towson.maddox.healthhelper.data.model.vitals.VitalSign
import edu.towson.maddox.healthhelper.data.model.vitals.uVitals
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.generics.ItemListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class VitalSignListViewModel(app : Application) : ItemListViewModel<uVitals, VitalSign, RecordingMethod, Int?, Int?>(app)
{
    init
    {
        viewModelScope.launch { setItems() }
    }

    override suspend fun setUserItems(): List<uVitals>
    {
        return repo.getUserVitals() ?: listOf()
    }

    override suspend fun setSubItems1(): List<VitalSign>
    {
        return repo.getVitalSigns() ?: listOf()
    }

    override suspend fun setSubItems2(): List<RecordingMethod>
    {
        return repo.getRecordingMethods() ?: listOf()
    }

    override suspend fun setSubItems3(): List<Int?>
    {
        return emptyList()
    }

    override suspend fun setSubItems4(): List<Int?>
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

    override fun deleteUserItem(item: uVitals)
    {
        viewModelScope.launch{
            repo.deleteUserVital(item)
            reloadUserItems()
        }
    }
}