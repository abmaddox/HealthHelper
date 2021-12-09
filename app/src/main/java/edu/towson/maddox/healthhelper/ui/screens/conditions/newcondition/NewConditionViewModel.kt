package edu.towson.maddox.healthhelper.ui.screens.conditions.newcondition

import edu.towson.maddox.healthhelper.data.model.conditions.Condition
import edu.towson.maddox.healthhelper.data.model.conditions.uConditions
import edu.towson.maddox.healthhelper.data.model.vm.NewItemViewModel
import edu.towson.maddox.healthhelper.data.repo.HealthRepo

class NewConditionViewModel(
    private val repo: HealthRepo,
    private val user_id: Int
) : NewItemViewModel<Condition, Int?, Int?, Int?>(repo, user_id) {
    override suspend fun setSubItems1(): List<Condition> {
        return repo.getConditions()
    }

    override suspend fun setSubItems2(): List<Int?> {
        return listOf()
    }

    override suspend fun setSubItems3(): List<Int?> {
        return listOf()
    }

    override suspend fun setSubItems4(): List<Int?> {
        return listOf()
    }

    override suspend fun addUserItem() {
        repo.insertUserConditions(uConditions(user_id = user_id, subItems1.value[selectedIndex1.value].condition_id,getStartDate(),getEndDate()))
    }
}