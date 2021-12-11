package edu.towson.maddox.healthhelper.ui.screens.viewmodels.riskfactors

import edu.towson.maddox.healthhelper.data.model.riskFactors.RiskFactor
import edu.towson.maddox.healthhelper.data.model.riskFactors.uRiskFactors
import edu.towson.maddox.healthhelper.data.repo.HealthRepo
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.generics.NewItemViewModel

class NewRiskFactorViewModel(private val repo : HealthRepo, private val userId : Int) : NewItemViewModel<RiskFactor, Int?, Int?, Int?>()
{
    override suspend fun setSubItems1(): List<RiskFactor>
    {
        return repo.getRiskFactors()
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
        repo.insertUserRiskFactors(uRiskFactors(user_id = userId, factor_id = getSubItem1().factor_id))
    }
}