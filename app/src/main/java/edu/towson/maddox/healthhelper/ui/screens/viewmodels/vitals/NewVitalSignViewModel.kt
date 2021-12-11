package edu.towson.maddox.healthhelper.ui.screens.viewmodels.vitals

import androidx.lifecycle.viewModelScope
import edu.towson.maddox.healthhelper.data.model.vitals.RecordingMethod
import edu.towson.maddox.healthhelper.data.model.vitals.VitalSign
import edu.towson.maddox.healthhelper.data.model.vitals.uVitals
import edu.towson.maddox.healthhelper.data.repo.HealthRepo
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.generics.NewItemViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewVitalSignViewModel(private val repo : HealthRepo, private val user_id : Int) : NewItemViewModel<VitalSign, RecordingMethod, Int?, Int?>()
{
    override suspend fun setSubItems1(): List<VitalSign> {
        return withContext(viewModelScope.coroutineContext + Dispatchers.IO) {
            repo.getVitalSigns()
        }
    }

    override suspend fun setSubItems2(): List<RecordingMethod> {
        return withContext(viewModelScope.coroutineContext + Dispatchers.IO) {
            repo.getRecordingMethods()
        }
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
                    user_id,
                    getSubItem1().vital_id,
                    getSubItem2().rMethod_id,
                    measurement = numeric.value
                )
            )
        }
    }
}