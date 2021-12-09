package edu.towson.maddox.healthhelper.ui.screens.conditions.newcondition

import edu.towson.maddox.healthhelper.data.model.symptoms.Symptom
import edu.towson.maddox.healthhelper.data.model.vm.NewItemViewModel
import edu.towson.maddox.healthhelper.data.repo.HealthRepo

class NewConditionViewModel(
    private val repo: HealthRepo,
    private val user_id: Int,
    sub1: List<Symptom>,
    sub2: List<Int?>,
    sub3: List<Int?>,
    sub4: List<Int?>
) : NewItemViewModel<Symptom, Int?, Int?, Int?>(repo, user_id, sub1, sub2, sub3, sub4) {
}