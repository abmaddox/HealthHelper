package edu.towson.maddox.healthhelper.nav

sealed class Routes (val route: String){
    object RiskFactors: Routes("RiskFactors")
    object Conditions: Routes("Conditions")
    object Medications: Routes("Medications")
    object Survey: Routes("Survey")
    object AddVital: Routes("AddVital")
    object Main: Routes("Main")
    object Login: Routes("Login")
    object Signup: Routes("Signup")
}
