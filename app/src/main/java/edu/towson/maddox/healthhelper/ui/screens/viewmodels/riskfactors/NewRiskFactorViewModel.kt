package edu.towson.maddox.healthhelper.ui.screens.viewmodels.riskfactors

import android.app.Application
import androidx.lifecycle.viewModelScope
import edu.towson.maddox.healthhelper.data.model.riskFactors.RiskFactor
import edu.towson.maddox.healthhelper.data.model.riskFactors.uRiskFactors
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.generics.NewItemViewModel
import kotlinx.coroutines.launch

class NewRiskFactorViewModel(app : Application) : NewItemViewModel<RiskFactor, Int?, Int?, Int?>(app)
{
    init
    {
        viewModelScope.launch { setItems() }
    }

    override suspend fun setSubItems1(): List<RiskFactor>
    {
        return repo.getRiskFactors() ?: listOf()
    }

    override suspend fun setSubItems2(): List<Int?>
    {
        return listOf()
    }

    override suspend fun setSubItems3(): List<Int?>
    {
        return listOf()
    }

    override suspend fun setSubItems4(): List<Int?>
    {
        return listOf()
    }

    override suspend fun addUserItem()
    {
        repo.insertUserRiskFactors(uRiskFactors(user_id = repo.returnUserId(), factor_id = getSubItem1().factor_id))
    }
}