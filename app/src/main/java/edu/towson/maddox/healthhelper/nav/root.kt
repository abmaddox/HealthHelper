package edu.towson.maddox.healthhelper.nav

import android.app.Application
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import edu.towson.maddox.healthhelper.db.DB

@ExperimentalMaterialApi
@Composable
fun Root(app : Application)
{
    Scaffold(
        topBar = {
            Text(text = "Health Helper")
        }
    ) {
        val db = Room.databaseBuilder(
            app.applicationContext,
            DB::class.java, "SongsDB"
        ).build()
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Routes.Login.route) {

            composable(Routes.Signup.route) { }

            composable(Routes.Main.route) { }

            composable(Routes.Vitals.route) { }

            composable(Routes.AddVital.route) { }

            composable(Routes.Conditions.route) { }

            composable(Routes.AddCondition.route) { }

            composable(Routes.Medications.route) { }

            composable(Routes.AddMedication.route) { }

            composable(Routes.RiskFactors.route) { }

            composable(Routes.AddRiskFactor.route) { }

            composable(Routes.Surveys.route) { }

            composable(Routes.TakeSurvey.route) { }
        }
    }
}
