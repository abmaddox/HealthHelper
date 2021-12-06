package edu.towson.maddox.healthhelper.data.repo

import edu.towson.maddox.healthhelper.data.model.User
import edu.towson.maddox.healthhelper.data.model.conditions.Condition
import edu.towson.maddox.healthhelper.data.model.conditions.uConditions
import edu.towson.maddox.healthhelper.data.model.medications.*
import edu.towson.maddox.healthhelper.data.model.riskFactors.RiskFactor
import edu.towson.maddox.healthhelper.data.model.riskFactors.uRiskFactors
import edu.towson.maddox.healthhelper.data.model.symptoms.Symptom
import edu.towson.maddox.healthhelper.data.model.symptoms.uSymptoms
import edu.towson.maddox.healthhelper.data.model.vitals.RecordingMethod
import edu.towson.maddox.healthhelper.data.model.vitals.VitalSign
import edu.towson.maddox.healthhelper.data.model.vitals.uVitals

interface IHealthRepo {
    //GETTERS

        //User
        suspend fun getUserId(username : String, password : String) : Int?

        //Vital sign
        suspend fun getUserVitals(id : Int) : List<uVitals>?
        suspend fun getRecordingMethods() : List<RecordingMethod>?
        suspend fun getVitalSigns() : List<VitalSign>?

        //Symptoms
        suspend fun getSymptoms() : List<Symptom>?
        suspend fun getUserSymptoms(id : Int) : List<uSymptoms>?

        //Medications
        suspend fun getUserMeds(id : Int) : List<uMedications>?
        suspend fun getDoseUnits() : List<DoseUnit>?
        suspend fun getFrequencies() : List<Frequency>?
        suspend fun getMedication() : List<Medication>?
        suspend fun getAdminMethods() : List<AdministrationMethod>?

        //Risk factors
        suspend fun getRiskFactors() : List<RiskFactor>?
        suspend fun getUserRiskFactors( id: Int ) : List<uRiskFactors>?

        //Conditions
        suspend fun getConditions() : List<Condition>?
        suspend fun getUserConditions(id : Int) : List<uConditions>?

        //SETTERS

        //User
        suspend fun insertNewUser(u: User)

        //Vital sign
        suspend fun insertUserVital(uv : uVitals)
        suspend fun insertRecordingMethod(rm : RecordingMethod)
        suspend fun insertVitalSigns(vs : VitalSign)

        //Symptoms
        suspend fun insertSymptom(s : Symptom)
        suspend fun insertUserSymptoms(us : uSymptoms)

        //Medications
        suspend fun insertUserMeds(um : uMedications)
        suspend fun insertDoseUnits(du : DoseUnit)
        suspend fun insertFrequencies(f : Frequency)
        suspend fun insertMedication(m : Medication)
        suspend fun insertAdminMethods(am : AdministrationMethod)

        //Risk factors
        suspend fun insertRiskFactors(rf : RiskFactor)
        suspend fun insertUserRiskFactors( urf : uRiskFactors)

        //Conditions
        suspend fun insertConditions(c : Condition)
        suspend fun insertUserConditions(uc : uConditions)

    //UPDATERS

        //User
        suspend fun updateUser(u: User)

        //Vital sign
        suspend fun updateUserVital(uv : uVitals)
        suspend fun updateRecordingMethod(rm : RecordingMethod)
        suspend fun updateVitalSigns(vs : VitalSign)

        //Symptoms
        suspend fun updateSymptom(s : Symptom)
        suspend fun updateUserSymptoms(us : uSymptoms)

        //Medications
        suspend fun updateUserMeds(um : uMedications)
        suspend fun updateDoseUnits(du : DoseUnit)
        suspend fun updateFrequencies(f : Frequency)
        suspend fun updateMedication(m : Medication)
        suspend fun updateAdminMethods(am : AdministrationMethod)

        //Risk factors
        suspend fun updateRiskFactors(rf : RiskFactor)
        suspend fun updateUserRiskFactors( urf : uRiskFactors )

        //Conditions
        suspend fun updateConditions(c : Condition)
        suspend fun updateUserConditions(uc : uConditions)



}