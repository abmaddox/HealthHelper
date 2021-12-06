package edu.towson.maddox.healthhelper.nav

sealed class Routes (val route: String){
    object Vitals: Routes("Vitals")
    object AddVital: Routes("AddVital")
    object RiskFactors: Routes("RiskFactors")
    object AddRiskFactor: Routes("AddRiskFactors")
    object Conditions: Routes("Conditions")
    object AddCondition: Routes("AddConditions")
    object Medications: Routes("Medications")
    object AddMedication: Routes("AddMedications")
    object Surveys: Routes("Survey")
    object TakeSurvey: Routes("TakeSurvey")
    object Main: Routes("Main")
    object Login: Routes("Login")
    object Signup: Routes("Signup")
}
