package edu.towson.maddox.healthhelper.ui.screens.main.signup

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.towson.maddox.healthhelper.data.model.User
import edu.towson.maddox.healthhelper.data.repo.HealthRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignupViewModel(private val repo: HealthRepo) : ViewModel(){
    private val _user : MutableState<User> = mutableStateOf(User(username = "", password = ""))
    val user = _user

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
            if (!_showCopyValidationText.value && !_showMatchValidationText.value) {
                _user.value = _user.value.copy(username = _username.value, password = _password.value)
                withContext(context = viewModelScope.coroutineContext + Dispatchers.IO) {
                    repo.insertNewUser(_user.value)
                    _valid.value = true
                }
            } else
                _valid.value = false
        }
    }

    private fun checkForPasswordMatch(){
        _showMatchValidationText.value = _confirmPassword.value != _password.value
    }

    private suspend fun checkForExistingUsers(){
        var _user_id : Int?
            withContext(context = viewModelScope.coroutineContext + Dispatchers.IO) {
            _user_id = repo.getUserId(username = _username.value, password = _password.value)
                _showCopyValidationText.value = _user_id != null
        }
    }
}