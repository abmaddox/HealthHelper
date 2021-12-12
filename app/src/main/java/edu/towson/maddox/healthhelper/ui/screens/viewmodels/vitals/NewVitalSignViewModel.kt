package edu.towson.maddox.healthhelper.ui.screens.viewmodels.vitals

import android.app.Application
import androidx.lifecycle.viewModelScope
import edu.towson.maddox.healthhelper.data.model.vitals.RecordingMethod
import edu.towson.maddox.healthhelper.data.model.vitals.VitalSign
import edu.towson.maddox.healthhelper.data.model.vitals.uVitals
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.generics.NewItemViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewVitalSignViewModel(app : Application) : NewItemViewModel<VitalSign, RecordingMethod, Int?, Int?>(app)
{
    init
    {
        viewModelScope.launch { setItems() }
    }

    override suspend fun setSubItems1(): List<VitalSign> {
        return repo.getVitalSigns() ?: listOf()
    }

    override suspend fun setSubItems2(): List<RecordingMethod> {
        return repo.getRecordingMethods() ?: listOf()
    }

    override suspend fun setSubItems3(): List<Int?> {
       return listOf()
    }

    override suspend fun setSubItems4(): List<Int?> {
        return listOf()
    }

    override suspend fun addUserItem() {
        viewModelScope.launch(Dispatchers.IO)
        {
            repo.insertUserVital(
                uVitals(
                    repo.returnUserId(),
                    getSubItem1().vital_id,
                    getSubItem2().rMethod_id,
                    measurement = numeric.value
                )
            )
        }
    }
}