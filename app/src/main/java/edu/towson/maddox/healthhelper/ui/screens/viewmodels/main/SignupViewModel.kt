package edu.towson.maddox.healthhelper.ui.screens.viewmodels.main

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import edu.towson.maddox.healthhelper.data.model.User
import edu.towson.maddox.healthhelper.data.repo.HealthRepo
import edu.towson.maddox.healthhelper.data.repo.IHealthRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignupViewModel(app : Application) : AndroidViewModel(app){

    val repo : IHealthRepo = HealthRepo(app)
    private val _username = mutableStateOf("")
    val username = _username

    private val _password = mutableStateOf("")
    val password = _password

    private val _confirmPassword = mutableStateOf("")
    val confirmPassword = _confirmPassword

    private val _showMatchValidationText = mutableStateOf(false)
    val showMatchValidationText = _showMatchValidationText

    private val _showCopyValidationText = mutableStateOf(false)
    val showCopyValidationText = _showCopyValidationText

    private val _valid = mutableStateOf(false)
    val valid = _valid

    fun setUsername(s: String){
        _username.value = s
    }

    fun setPassword(s : String){
        _password.value = s
    }

    fun setConfirmPassword(s : String){
        _confirmPassword.value = s
    }

    fun validate(){
        viewModelScope.launch(Dispatchers.IO){
            checkForExistingUsers()
            checkForPasswordMatch()
            if (!_showCopyValidationText.value && !_showMatchValidationText.value)
            {
                viewModelScope.launch(Dispatchers.Main ) {
                    _valid.value = true
                }
                repo.insertNewUser(User(username = _username.value, password = _password.value))
            }
            else
            {
                viewModelScope.launch(Dispatchers.Main)
                {
                    _valid.value = false
                }
            }
        }
    }

    fun checkForPasswordMatch(){
        _showMatchValidationText.value = _confirmPassword.value != _password.value
    }

    fun clearErrors(){
        _showMatchValidationText.value = false
        _showCopyValidationText.value = false
    }

    private suspend fun checkForExistingUsers(){
        val userId : Int?
            withContext(context = viewModelScope.coroutineContext + Dispatchers.IO) {
                userId = repo.getUserId(username = _username.value, password = _password.value)
                _showCopyValidationText.value = userId != null
        }
    }

    fun toggleValid()
    {
        _valid.value = !_valid.value
    }

    fun clearFields()
    {
        _username.value = ""
        _password.value = ""
        _confirmPassword.value = ""
    }
}