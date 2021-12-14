package edu.towson.maddox.healthhelper.ui.screens.viewmodels.vitals

import androidx.lifecycle.viewModelScope
import edu.towson.maddox.healthhelper.data.model.vitals.RecordingMethod
import edu.towson.maddox.healthhelper.data.model.vitals.VitalSign
import edu.towson.maddox.healthhelper.data.model.vitals.uVitals
import edu.towson.maddox.healthhelper.data.repo.HealthRepo
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.generics.NewItemViewModel
import kotlinx.coroutines.launch

class NewVitalSignViewModel(private val repo : HealthRepo) : NewItemViewModel<VitalSign, RecordingMethod, Int?, Int?>()
{
    init
    {
        viewModelScope.launch { setItems() }
    }

    override fun setSubItems1(): List<VitalSign> {
        return repo.getVitalSigns()
    }

    override fun setSubItems2(): List<RecordingMethod> {
        return repo.getRecordingMethods()
    }

    override fun setSubItems3(): List<Int?> {
       return listOf()
    }

    override fun setSubItems4(): List<Int?> {
        return listOf()
    }

    override fun addUserItem() {
        if (numeric.value<=0.0)
        {
            toggleErrorPopupVisible()
            throw Exception("error")
        }
        else if (selectedIndex2.value == 1 || selectedIndex1.value == 1)
        {
            toggleNoChangePopupVisible()
            throw Exception("error")
        }
        else
        {
            proceedToAddUserItem()
        }
    }

    override fun proceedToAddUserItem()
    {
        val item = uVitals(
            user_id = repo.returnUserId(),
            vital_id = getSubItem1().vital_id,
            rMethod_id = getSubItem2().rMethod_id,
            measurement = numeric.value
        )
        repo.addUserVitals(item)
        viewModelScope.launch {
            repo.insertUserVital(item)
            repo.setUserVitals()
        }
    }


}