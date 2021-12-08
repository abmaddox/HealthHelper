package edu.towson.maddox.healthhelper.ui.screens.main.signup

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.towson.maddox.healthhelper.data.model.User
import edu.towson.maddox.healthhelper.data.repo.HealthRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SignupViewModel(private val dao: HealthRepo) : ViewModel(){
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

    fun setUsername(s: String){
        _username.value = s
    }

    fun setPassword(s : String){
        _password.value = s
    }

    suspend fun validate() : Boolean{
        var copy : Boolean = checkForExistingUsers()
        var match : Boolean = checkForPasswordMatch()
        val valid = copy!=match
        return if (valid) {
            _user.value = _user.value.copy(username = _username.value, password = _password.value)
            withContext(context = viewModelScope.coroutineContext + Dispatchers.IO) {
                dao.insertNewUser(_user.value)
                valid
            }
        } else
            valid
    }

    private fun checkForPasswordMatch() : Boolean{
        _showMatchValidationText.value = _confirmPassword.value != _password.value
        return _confirmPassword.value == _password.value
    }

    private suspend fun checkForExistingUsers() : Boolean{
        var _user_id : Int?
        return withContext(context = viewModelScope.coroutineContext + Dispatchers.IO) {
            _user_id = dao.getUserId(username = username.value, password = password.value)
            if (_user_id == null) {
                _showCopyValidationText.value = false
                false
            } else {
                _showCopyValidationText.value = true
                true
            }
        }
    }
}