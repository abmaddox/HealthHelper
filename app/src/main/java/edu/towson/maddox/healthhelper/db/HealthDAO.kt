package edu.towson.maddox.healthhelper.db

import androidx.room.*
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

@Dao
interface HealthDAO {
    //GETTERS

        //User
        @Query("SELECT user_id from user WHERE username=:username AND password=:password")
        suspend fun getUserId(username : String, password : String) : Int?

        //Vital sign
        @Query("SELECT * from uVitals WHERE user_id=:id")
        suspend fun getUserVitals(id: Int?) : List<uVitals>

        @Query("SELECT * FROM recordingMethod")
        suspend fun getRecordingMethods(): List<RecordingMethod>
        @Query("SELECT * FROM vitalSign")
        suspend fun getVitalSigns() : List<VitalSign>

        //Symptoms
        @Query("SELECT * FROM symptom")
        suspend fun getSymptoms() : List<Symptom>
        @Query("SELECT * from uSymptoms WHERE user_id=:id")
        suspend fun getUserSymptoms(id: Int?) : List<uSymptoms>

        //Medications
        @Query("SELECT * from uMedications WHERE user_id=:id")
        suspend fun getUserMeds(id: Int?) : List<uMedications>
        @Query("SELECT * FROM doseUnit")
        suspend fun getDoseUnits() : List<DoseUnit>
        @Query("SELECT * FROM frequency")
        suspend fun getFrequencies() : List<Frequency>
        @Query("SELECT * FROM medication")
        suspend fun getMedication() : List<Medication>
        @Query("SELECT * FROM administrationMethod")
        suspend fun getAdminMethods() : List<AdministrationMethod>

        //Risk factors
        @Query("SELECT * FROM riskFactor")
        suspend fun getRiskFactors() : List<RiskFactor>
        @Query("SELECT * from uRiskFactors WHERE user_id=:id")
        suspend fun getUserRiskFactors(id: Int?) : List<uRiskFactors>

        //Conditions
        @Query("SELECT * FROM condition")
        suspend fun getConditions() : List<Condition>
        @Query("SELECT * from uConditions WHERE user_id=:id")
        suspend fun getUserConditions(id: Int?) : List<uConditions>

    //SETTERS

        //User
        @Insert
        suspend fun insertNewUser(u: User)

        //Vital sign
        @Insert
        suspend fun insertUserVital(uv : uVitals)
        @Insert
        suspend fun insertRecordingMethod(rm : RecordingMethod)
        @Insert
        suspend fun insertVitalSigns(vs : VitalSign)

        //Symptoms
        @Insert
        suspend fun insertSymptom(s : Symptom)
        @Insert
        suspend fun insertUserSymptoms(us : uSymptoms)

        //Medications
        @Insert
        suspend fun insertUserMeds(um : uMedications)
        @Insert
        suspend fun insertDoseUnits(du : DoseUnit)
        @Insert
        suspend fun insertFrequencies(f : Frequency)
        @Insert
        suspend fun insertMedication(m : Medication)
        @Insert
        suspend fun insertAdminMethods(am : AdministrationMethod)

        //Risk factors
        @Insert
        suspend fun insertRiskFactors(rf : RiskFactor)
        @Insert
        suspend fun insertUserRiskFactors(uv: uRiskFactors)

        //Conditions
        @Insert
        suspend fun insertConditions(c : Condition)
        @Insert
        suspend fun insertUserConditions(uc : uConditions)

    //UPDATERS

        //User
        @Update
        suspend fun updateUser(u: User)

        //Vital sign
        @Update
        suspend fun updateUserVital(uv : uVitals)
        @Update
        suspend fun updateRecordingMethod(rm : RecordingMethod)
        @Update
        suspend fun updateVitalSigns(vs : VitalSign)

        //Symptoms
        @Update
        suspend fun updateSymptom(s : Symptom)
        @Update
        suspend fun updateUserSymptoms(us : uSymptoms)

        //Medications
        @Update
        suspend fun updateUserMeds(um : uMedications)
        @Update
        suspend fun updateDoseUnits(du : DoseUnit)
        @Update
        suspend fun updateFrequencies(f : Frequency)
        @Update
        suspend fun updateMedication(m : Medication)
        @Update
        suspend fun updateAdminMethods(am : AdministrationMethod)

        //Risk factors
        @Update
        suspend fun updateRiskFactors(rf : RiskFactor)
        @Update
        suspend fun updateUserRiskFactors(urf: uRiskFactors)

        //Conditions
        @Update
        suspend fun updateConditions(c : Condition)
        @Update
        suspend fun updateUserConditions(uc : uConditions)


//DELETES
        //TODO implement deletion according to integrity constraints
//        //User
//        @Delete
//        fun deleteUser(u: User)

        //Vital sign
        @Delete
        suspend fun deleteUserVital(uv : uVitals)

        //Symptoms
        @Delete
        suspend fun deleteUserSymptoms(us : uSymptoms)

        //Medications
        @Delete
        suspend fun deleteUserMeds(um : uMedications)

        //Risk factors
        @Delete
        suspend fun deleteUserRiskFactors(urf: uRiskFactors)

        //Conditions
        @Delete
        suspend fun deleteUserConditions(uc : uConditions)
}