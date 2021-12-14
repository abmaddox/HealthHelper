package edu.towson.maddox.healthhelper.nav

sealed class Routes (val route: String){
    object Loading : Routes("Loading")
    object Vitals: Routes("Vital Signs")
    object AddVital: Routes("New Vital Sign")
    object RiskFactors: Routes("Risk Factors")
    object AddRiskFactor: Routes("New Risk Factor")
    object Conditions: Routes("Conditions")
    object AddCondition: Routes("New Condition")
    object Medications: Routes("Medications")
    object AddMedication: Routes("New Medication")
    object Symptoms: Routes("Symptoms")
    object AddSymptom: Routes("New Symptom")
    object Home: Routes("Home")
    object Login: Routes("Login")
    object Signup: Routes("Signup")
}
