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
        fun returnUserId(): Int

        //Vital sign
        fun getUserVitals() : List<uVitals>
        fun getRecordingMethods() : List<RecordingMethod>
        fun getVitalSigns() : List<VitalSign>

        //Symptoms
        fun getSymptoms() : List<Symptom>
        fun getUserSymptoms() : List<uSymptoms>

        //Medications
        fun getUserMeds() : List<uMedications>
        fun getDoseUnits() : List<DoseUnit>
        fun getFrequencies() : List<Frequency>
        fun getMedication() : List<Medication>
        fun getAdminMethods() : List<AdministrationMethod>

        //Risk factors
        fun getRiskFactors() : List<RiskFactor>
        fun getUserRiskFactors() : List<uRiskFactors>

        //Conditions
        fun getConditions() : List<Condition>
        fun getUserConditions() : List<uConditions>

//Internal setters

        fun setUserId(i : Int)
        suspend fun loadDefaults()
        fun loadUserItems()

        //Vital sign
        suspend fun setUserVitals()
        suspend fun setRecordingMethods()
        suspend fun setVitalSigns()

        //Symptoms
        suspend fun setSymptoms()
        suspend fun setUserSymptoms()

        //Medications
        suspend fun setUserMeds()
        suspend fun setDoseUnits()
        suspend fun setFrequencies()
        suspend fun setMedication()
        suspend fun setAdminMethods()

        //Risk factors
        suspend fun setRiskFactors()
        suspend fun setUserRiskFactors()

        //Conditions
        suspend fun setConditions()
        suspend fun setUserConditions()


        //Inserters

        //Sample Data
        suspend fun insertDummyValues()

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

        //Internal inserters
        //Vital sign
        fun addUserVitals(uv : uVitals)

        //Symptoms
        fun addUserSymptoms(us : uSymptoms)

        //Medications
        fun addUserMeds(umed : uMedications)

        //Risk factors
        fun addUserRiskFactors(urf : uRiskFactors)

        //Conditions
        fun addUserConditions(uc : uConditions)

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

//DELETES
        //TODO implement deletion according to integrity constraints
//        //User
//        @Delete
//        suspend fun deleteUser(u: User)

        //Vital sign
        suspend fun deleteUserVital(uv : uVitals)

        //Symptoms
        suspend fun deleteUserSymptoms(us : uSymptoms)

        //Medications
        suspend fun deleteUserMeds(um : uMedications)

        //Risk factors
        suspend fun deleteUserRiskFactors(urf: uRiskFactors)

        //Conditions
        suspend fun deleteUserConditions(uc : uConditions)

}