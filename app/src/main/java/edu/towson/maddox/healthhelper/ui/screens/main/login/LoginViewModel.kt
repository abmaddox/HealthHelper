package edu.towson.maddox.healthhelper.ui.screens.main.login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.towson.maddox.healthhelper.data.repo.HealthRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(private val dao: HealthRepo) : ViewModel(){
    private val _username = mutableStateOf("")
    val username = _username

    private val _password = mutableStateOf("")
    val password = _password

    private val _user_id : MutableState<Int?> = mutableStateOf(null)

    private val _showValidationText = mutableStateOf(false)
    val showValidationText = _showValidationText

    fun setUsername(s: String){
        _username.value = s
    }

    fun setPassword(s : String){
        _password.value = s
    }

    suspend fun validate() : Int?{
        viewModelScope.launch(Dispatchers.IO){
            _user_id.value = dao.getUserId(username = username.value, password = password.value)
        }
        return if (_user_id.value != null) {
            _showValidationText.value = false
            _user_id.value
        } else{
            _showValidationText.value = true
            _user_id.value
        }
    }
}