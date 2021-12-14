package edu.towson.maddox.healthhelper.ui.screens.viewmodels.riskfactors

import androidx.lifecycle.viewModelScope
import edu.towson.maddox.healthhelper.data.model.riskFactors.RiskFactor
import edu.towson.maddox.healthhelper.data.model.riskFactors.uRiskFactors
import edu.towson.maddox.healthhelper.data.repo.HealthRepo
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.generics.NewItemViewModel
import kotlinx.coroutines.launch

class NewRiskFactorViewModel(private val repo : HealthRepo) : NewItemViewModel<RiskFactor, Int?, Int?, Int?>()
{
    init
    {
        viewModelScope.launch { setItems() }
    }

    override fun setSubItems1(): List<RiskFactor>
    {
        return repo.getRiskFactors()
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

    override fun addUserItem()
    {
        if (selectedIndex1.value == null)
        {
            toggleErrorPopupVisible()
            throw Exception("error")
        }
        else
        {
            val item = uRiskFactors(user_id = repo.returnUserId(), factor_id = getSubItem1().factor_id)
            repo.addUserRiskFactors(item)
            viewModelScope.launch {
                repo.insertUserRiskFactors(item)
                repo.setUserRiskFactors()
            }
        }
    }
}