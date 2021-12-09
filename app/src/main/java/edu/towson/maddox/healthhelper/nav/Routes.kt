package edu.towson.maddox.healthhelper.nav

sealed class Routes (val route: String){
    object Vitals: Routes("Vitals")
    object AddVital: Routes("AddVital")
    object RiskFactors: Routes("RiskFactors")
    object AddRiskFactor: Routes("AddRiskFactor")
    object Conditions: Routes("Conditions")
    object AddCondition: Routes("AddCondition")
    object Medications: Routes("Medications")
    object AddMedication: Routes("AddMedication")
    object Symptoms: Routes("Symptoms")
    object AddSymptom: Routes("AddSymptom")
    object Home: Routes("Home")
    object Login: Routes("Login")
    object Signup: Routes("Signup")
}
