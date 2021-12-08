package edu.towson.maddox.healthhelper.ui.screens.conditions.conditionlist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.towson.maddox.healthhelper.data.model.conditions.Condition
import edu.towson.maddox.healthhelper.data.model.conditions.uConditions
import edu.towson.maddox.healthhelper.data.repo.HealthRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ConditionListViewModel(private val repo: HealthRepo, private val user_id : Int) : ViewModel() {
    private val _userConditions: MutableState<List<uConditions>> = mutableStateOf(listOf())
    val userConditions = _userConditions

    private val _conditions: MutableState<List<Condition>> = mutableStateOf(listOf())
    val conditions = _conditions


    init {
        viewModelScope.launch(Dispatchers.IO){
            _userConditions.value = repo.getUserConditions(user_id)
        }
    }

    fun getCond(cond_id : Int): Condition {
        return _conditions.value.filter { it.condition_id == cond_id }[0]
    }
}