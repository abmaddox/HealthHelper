package edu.towson.maddox.healthhelper.ui.screens.conditions.newcondition

import edu.towson.maddox.healthhelper.data.model.symptoms.Symptom
import edu.towson.maddox.healthhelper.data.model.vm.NewItemViewModel
import edu.towson.maddox.healthhelper.data.repo.HealthRepo

class NewConditionViewModel(
    private val repo: HealthRepo,
    private val user_id: Int
) : NewItemViewModel<Symptom, Int?, Int?, Int?>(repo, user_id) {
    override suspend fun setSubItems1(): List<Symptom> {
        TODO("Not yet implemented")
    }

    override suspend fun setSubItems2(): List<Int?> {
        TODO("Not yet implemented")
    }

    override suspend fun setSubItems3(): List<Int?> {
        TODO("Not yet implemented")
    }

    override suspend fun setSubItems4(): List<Int?> {
        TODO("Not yet implemented")
    }

    override suspend fun addUserItem() {
        TODO("Not yet implemented")
    }
}