package edu.towson.maddox.healthhelper.ui.screens.viewmodels.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.towson.maddox.healthhelper.data.repo.HealthRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel(private val repo : HealthRepo) : ViewModel(){

    private val _validating : MutableState<Boolean> = mutableStateOf(false)
    val validating = _validating

    private val _username = mutableStateOf("")
    val username = _username

    private val _password = mutableStateOf("")
    val password = _password

    private val _user_id : MutableState<Int?> = mutableStateOf(null)
    val user_id = _user_id

    private val _navigate = mutableStateOf(false)
    val navigate = _navigate

    private val _showValidationText = mutableStateOf(false)
    val showValidationText = _showValidationText

    fun toggleNavigate(){
        _navigate.value = !_navigate.value
    }

    fun setUsername(s: String){
        _username.value = s
    }

    fun setPassword(s : String){
        _password.value = s
    }

    fun setShowValidationText(b : Boolean){
        _showValidationText.value = b
    }

    fun validate(){
        _validating.value = true

        viewModelScope.launch(Dispatchers.Main){
            fetchUserId()
            if (_user_id.value != null) {
                    _validating.value = false
                    _showValidationText.value = false
                    _navigate.value = true
            } else {
                    _validating.value = false
                    _showValidationText.value = true
            }
        }
    }

    private suspend fun fetchUserId(){
        _user_id.value =
            withContext(viewModelScope.coroutineContext + Dispatchers.IO)
            {
                repo.getUserId(
                    username = username.value,
                    password = password.value
                )
            }
    }
}