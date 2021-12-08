package edu.towson.maddox.healthhelper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.room.Room
import edu.towson.maddox.healthhelper.db.DB
import edu.towson.maddox.healthhelper.nav.Root
import edu.towson.maddox.healthhelper.ui.theme.HealthHelperTheme

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HealthHelperTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val db : DB = Room.databaseBuilder(
                        applicationContext,
                        DB::class.java, "HealthDB"
                    ).build()
                    Root(db = db)
                }
            }
        }
    }
}