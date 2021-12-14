package edu.towson.maddox.healthhelper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import edu.towson.maddox.healthhelper.nav.Root
import edu.towson.maddox.healthhelper.nav.RootViewModel
import edu.towson.maddox.healthhelper.ui.theme.HealthHelperTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    @ExperimentalFoundationApi
    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HealthHelperTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val rootViewModel = RootViewModel(application)
                    Root(rootViewModel)
                }
            }
        }
    }
}
