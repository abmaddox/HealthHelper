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
    val user_id = _user_id

    private val _showValidationText = mutableStateOf(false)
    val showValidationText = _showValidationText

    private val _valid = mutableStateOf(false)
    val valid = _valid


    fun setUsername(s: String){
        _username.value = s
    }

    fun setPassword(s : String){
        _password.value = s
    }

    fun validate(){
        viewModelScope.launch(Dispatchers.IO){
            _user_id.value = dao.getUserId(username = username.value, password = password.value)
        }
        if (_user_id.value != null) {
            _valid.value = true
            _showValidationText.value = false

        } else{
            _showValidationText.value = true
            _valid.value = false
        }
    }
}