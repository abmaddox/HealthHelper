package edu.towson.maddox.healthhelper.ui.screens.main.signup

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun Signup(vm: SignupViewModel,
           onCancelClick : () -> Unit,
           onSignupClick : (String) -> Unit){
    val ctx = LocalContext.current
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)  {
        Text(text = "Welcome! Please signup below", modifier = Modifier.paddingFromBaseline(top = 15.dp, bottom = 15.dp))
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        if(vm.showMatchValidationText.value) {
            Text(
                text = "ERROR: Passwords do not match. Try retyping passwords.",
                color = Color.Red
            )
            Spacer(modifier = Modifier.padding(bottom = 10.dp))
        }
        if(vm.showCopyValidationText.value) {
            Text(
                text = "ERROR: An account with that username already exists. Please pick a new one.",
                color = Color.Red
            )
            Spacer(modifier = Modifier.padding(bottom = 10.dp))
        }
        UsernameTextField(vm)
        PasswordTextField(vm)
        PasswordTextField(vm, confirmField = true)
        Row(modifier = Modifier.padding(10.dp)) {

            Button(onClick = {
                vm.viewModelScope.launch(Dispatchers.IO)
                {
                    var valid = vm.validate()
                    if (valid) {
                        Toast.makeText(ctx, "Signup Successful!", Toast.LENGTH_SHORT).show()
                        onSignupClick(vm.username.value)
                    }
                }
            },
                modifier = Modifier.padding(horizontal = 15.dp)){
                Text(text = "Signup")
            }

            Button(onClick = { onCancelClick() },
                modifier = Modifier.padding(horizontal = 15.dp)){
                Text(text = "Return to login")
            }
        }
    }

}


@Composable
fun UsernameTextField(vm: SignupViewModel) {

    TextField(
        value = vm.username.value,
        onValueChange = { vm.setUsername(it) },
        label = { Text("Enter username") },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        modifier = Modifier.paddingFromBaseline(top = 15.dp, bottom = 15.dp)
    )
}

@Composable
fun PasswordTextField(vm: SignupViewModel, confirmField : Boolean = false) {
    var labelText = "Enter password"
    if (confirmField) labelText = "Confirm password"
    TextField(
        value = vm.password.value,
        onValueChange = { vm.setPassword(it) },
        label = { Text(labelText) },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier.paddingFromBaseline(top = 15.dp, bottom = 15.dp)
    )
}