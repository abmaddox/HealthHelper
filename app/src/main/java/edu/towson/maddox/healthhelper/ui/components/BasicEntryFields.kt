package edu.towson.maddox.healthhelper.ui.components

import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BasicEntryField(value: String, setValue : (String)->Unit, label: String, keyboardType: KeyboardType ){
    TextField(
        value = value,
        onValueChange = { setValue(it) },
        label = { Text(text = label) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        modifier = Modifier.paddingFromBaseline(top = 15.dp, bottom = 15.dp)
    )
}
@Preview
@Composable
fun testBasicEntryField(){
    BasicEntryField(value = "", setValue = {}, label = "Enter here", keyboardType = KeyboardType.Text)
}