package edu.towson.maddox.healthhelper.ui.screens.viewmodels.riskfactors

import android.app.Application
import androidx.lifecycle.viewModelScope
import edu.towson.maddox.healthhelper.data.model.riskFactors.RiskFactor
import edu.towson.maddox.healthhelper.data.model.riskFactors.uRiskFactors
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.generics.ItemListViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class RiskFactorsListViewModel(app : Application) : ItemListViewModel<uRiskFactors, RiskFactor, Int?, Int?, Int?>(app)
{
    init
    {
        viewModelScope.launch { setItems() }
    }

    override suspend fun setUserItems(): List<uRiskFactors>
    {
        return repo.getUserRiskFactors() ?: listOf()
    }

    override suspend fun setSubItems1(): List<RiskFactor>
    {
        return repo.getRiskFactors() ?: listOf()
    }

    override suspend fun setSubItems2(): List<Int>
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

    override fun getSubItem1(subitem_id: Int): RiskFactor
    {
        return subItems1.value.filter { subitem_id == it.factor_id }[0]
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

    override fun deleteUserItem(item: uRiskFactors)
    {
        viewModelScope.launch(Dispatchers.IO) {
            repo.deleteUserRiskFactors(item)
            reloadUserItems()
        }

    }
}