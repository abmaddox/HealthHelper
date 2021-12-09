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
        fun getUserId(username : String, password : String) : Int?

        //Vital sign
        @Query("SELECT * from uVitals WHERE user_id=:id")
        fun getUserVitals(id : Int) : List<uVitals>

        @Query("SELECT * FROM recordingMethod")
        fun getRecordingMethods(): List<RecordingMethod>
        @Query("SELECT * FROM vitalSign")
        fun getVitalSigns() : List<VitalSign>

        //Symptoms
        @Query("SELECT * FROM symptom")
        fun getSymptoms() : List<Symptom>
        @Query("SELECT * from uSymptoms WHERE user_id=:id")
        fun getUserSymptoms(id : Int) : List<uSymptoms>

        //Medications
        @Query("SELECT * from uMedications WHERE user_id=:id")
        fun getUserMeds(id : Int) : List<uMedications>
        @Query("SELECT * FROM doseUnit")
        fun getDoseUnits() : List<DoseUnit>
        @Query("SELECT * FROM frequency")
        fun getFrequencies() : List<Frequency>
        @Query("SELECT * FROM medication")
        fun getMedication() : List<Medication>
        @Query("SELECT * FROM administrationMethod")
        fun getAdminMethods() : List<AdministrationMethod>

        //Risk factors
        @Query("SELECT * FROM riskFactor")
        fun getRiskFactors() : List<RiskFactor>
        @Query("SELECT * from uRiskFactors WHERE user_id=:id")
        fun getUserRiskFactors( id: Int ) : List<uRiskFactors>

        //Conditions
        @Query("SELECT * FROM condition")
        fun getConditions() : List<Condition>
        @Query("SELECT * from uConditions WHERE user_id=:id")
        fun getUserConditions(id : Int) : List<uConditions>

    //SETTERS

        //User
        @Insert
        fun insertNewUser(u: User)

        //Vital sign
        @Insert
        fun insertUserVital(uv : uVitals)
        @Insert
        fun insertRecordingMethod(rm : RecordingMethod)
        @Insert
        fun insertVitalSigns(vs : VitalSign)

        //Symptoms
        @Insert
        fun insertSymptom(s : Symptom)
        @Insert
        fun insertUserSymptoms(us : uSymptoms)

        //Medications
        @Insert
        fun insertUserMeds(um : uMedications)
        @Insert
        fun insertDoseUnits(du : DoseUnit)
        @Insert
        fun insertFrequencies(f : Frequency)
        @Insert
        fun insertMedication(m : Medication)
        @Insert
        fun insertAdminMethods(am : AdministrationMethod)

        //Risk factors
        @Insert
        fun insertRiskFactors(rf : RiskFactor)
        @Insert
        fun insertUserRiskFactors(uv: uRiskFactors)

        //Conditions
        @Insert
        fun insertConditions(c : Condition)
        @Insert
        fun insertUserConditions(uc : uConditions)

    //UPDATERS

        //User
        @Update
        fun updateUser(u: User)

        //Vital sign
        @Update
        fun updateUserVital(uv : uVitals)
        @Update
        fun updateRecordingMethod(rm : RecordingMethod)
        @Update
        fun updateVitalSigns(vs : VitalSign)

        //Symptoms
        @Update
        fun updateSymptom(s : Symptom)
        @Update
        fun updateUserSymptoms(us : uSymptoms)

        //Medications
        @Update
        fun updateUserMeds(um : uMedications)
        @Update
        fun updateDoseUnits(du : DoseUnit)
        @Update
        fun updateFrequencies(f : Frequency)
        @Update
        fun updateMedication(m : Medication)
        @Update
        fun updateAdminMethods(am : AdministrationMethod)

        //Risk factors
        @Update
        fun updateRiskFactors(rf : RiskFactor)
        @Update
        fun updateUserRiskFactors(urf: uRiskFactors)

        //Conditions
        @Update
        fun updateConditions(c : Condition)
        @Update
        fun updateUserConditions(uc : uConditions)


//DELETES
        //TODO implement deletion according to integrity constraints
//        //User
//        @Delete
//        fun deleteUser(u: User)

        //Vital sign
        @Delete
        fun deleteUserVital(uv : uVitals)

        //Symptoms
        @Delete
        fun deleteUserSymptoms(us : uSymptoms)

        //Medications
        @Delete
        fun deleteUserMeds(um : uMedications)

        //Risk factors
        @Delete
        fun deleteUserRiskFactors(urf: uRiskFactors)

        //Conditions
        @Delete
        fun deleteUserConditions(uc : uConditions)
}