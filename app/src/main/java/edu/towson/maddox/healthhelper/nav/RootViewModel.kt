package edu.towson.maddox.healthhelper.nav

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.towson.maddox.healthhelper.data.repo.HealthRepo
import edu.towson.maddox.healthhelper.db.DB
import edu.towson.maddox.healthhelper.db.HealthDAO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RootViewModel(app : Application) : ViewModel()
{
    private val dao : HealthDAO = DB.getDatabase(app).healthDAO()
    val repo = HealthRepo(dao, viewModelScope)

    private val _waiting = mutableStateOf(true)
    val waiting = _waiting

    fun checkWaiting(){
         viewModelScope.launch {
                    delay(750)
                    _waiting.value = false
              }
    }

    fun loadDummies(){
        viewModelScope.launch { repo.insertDummyValues() }
    }
}