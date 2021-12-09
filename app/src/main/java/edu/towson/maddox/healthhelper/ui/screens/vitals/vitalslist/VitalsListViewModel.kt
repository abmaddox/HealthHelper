package edu.towson.maddox.healthhelper.ui.screens.vitals.vitalslist

import edu.towson.maddox.healthhelper.data.model.vitals.RecordingMethod
import edu.towson.maddox.healthhelper.data.model.vitals.VitalSign
import edu.towson.maddox.healthhelper.data.model.vitals.uVitals
import edu.towson.maddox.healthhelper.data.model.vm.ItemListViewModel
import edu.towson.maddox.healthhelper.data.repo.HealthRepo
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class VitalsListViewModel(private val repo: HealthRepo, private val user_id : Int) :
    ItemListViewModel<uVitals, VitalSign, RecordingMethod, Int?, Int?>(repo, user_id) {
    override suspend fun setUserItems(): List<uVitals> {
        return repo.getUserVitals(user_id)
    }

    override suspend fun setSubItems1(): List<VitalSign> {
        return repo.getVitalSigns()
    }

    override suspend fun setSubItems2(): List<RecordingMethod> {
        return repo.getRecordingMethods()
    }

    override suspend fun setSubItems3(): List<Int?> {
        return listOf()
    }

    override suspend fun setSubItems4(): List<Int?> {
        return listOf()
    }

    override fun getSubItem1(subitem_id: Int): VitalSign {
        return subItems1.value.filter { it.vital_id == subitem_id }[0]
    }

    override fun getSubItem2(subitem_id: Int): RecordingMethod {
        return subItems2.value.filter { it.rMethod_id == subitem_id }[0]
    }

    override fun getSubItem3(subitem_id: Int): Int? {
        return null
    }

    override fun getSubItem4(subitem_id: Int): Int? {
        return null
    }
}