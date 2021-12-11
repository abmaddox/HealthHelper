package edu.towson.maddox.healthhelper.ui.screens.composables.main

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
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.main.SignupViewModel

@Composable
fun Signup(vm: SignupViewModel,
           onCancelClick : () -> Unit,
           onSignupClick : () -> Unit)
{
    val ctx = LocalContext.current

    if (vm.valid.value){
        vm.toggleValid()
        Toast.makeText(ctx,"Signup successful",Toast.LENGTH_LONG ).show()
        onSignupClick()
        vm.clearErrors()
        vm.clearFields()
    }
    vm.checkForPasswordMatch()

    Column(modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)  {
        Text(text = "Welcome! Please signup below")
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
        PasswordTextField(vm, isConfirmField = true)
        Row(modifier = Modifier.padding(10.dp)) {

            Button(onClick = {
                vm.validate()
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
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        modifier = Modifier.paddingFromBaseline(top = 15.dp, bottom = 15.dp)
    )
}

@Composable
fun PasswordTextField(vm: SignupViewModel, isConfirmField : Boolean = false) {
    var labelText = "Enter password"
    var text = vm.password
    if (isConfirmField) {
        labelText = "Confirm password"
        text = vm.confirmPassword
    }
    TextField(
        value = text.value,
        onValueChange = { if (isConfirmField) vm.setConfirmPassword(it) else vm.setPassword(it) },
        label = { Text(labelText) },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier.paddingFromBaseline(top = 15.dp, bottom = 15.dp)
    )
}