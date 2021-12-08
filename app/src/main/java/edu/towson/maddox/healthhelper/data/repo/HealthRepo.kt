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
import edu.towson.maddox.healthhelper.db.HealthDAO

class HealthRepo(private val dao: HealthDAO) : IHealthRepo {

    override suspend fun getUserId(username : String, password : String): Int? {
        return dao.getUserId(username, password)
    }

    override suspend fun getUserVitals(id: Int): List<uVitals> {
        return dao.getUserVitals(id)
    }

    override suspend fun getRecordingMethods(): List<RecordingMethod> {
        return dao.getRecordingMethods()
    }

    override suspend fun getVitalSigns(): List<VitalSign> {
        return dao.getVitalSigns()
    }

    override suspend fun getSymptoms(): List<Symptom> {
        return dao.getSymptoms()
    }

    override suspend fun getUserSymptoms(id: Int): List<uSymptoms> {
        return dao.getUserSymptoms(id)
    }

    override suspend fun getUserMeds(id: Int): List<uMedications> {
        return dao.getUserMeds(id)
    }

    override suspend fun getDoseUnits(): List<DoseUnit> {
        return dao.getDoseUnits()
    }

    override suspend fun getFrequencies(): List<Frequency> {
        return dao.getFrequencies()
    }

    override suspend fun getMedication(): List<Medication> {
        return dao.getMedication()
    }

    override suspend fun getAdminMethods(): List<AdministrationMethod> {
        return dao.getAdminMethods()
    }

    override suspend fun getRiskFactors(): List<RiskFactor> {
        return dao.getRiskFactors()
    }

    override suspend fun getUserRiskFactors(id: Int): List<uRiskFactors> {
        return dao.getUserRiskFactors(id)
    }

    override suspend fun getConditions(): List<Condition> {
        return dao.getConditions()
    }

    override suspend fun getUserConditions(id: Int): List<uConditions> {
        return dao.getUserConditions(id)
    }

    override suspend fun insertNewUser(u: User) {
        dao.insertNewUser(u)
    }

    override suspend fun insertUserVital(uv: uVitals) {
        dao.insertUserVital(uv)
    }

    override suspend fun insertRecordingMethod(rm: RecordingMethod) {
        dao.insertRecordingMethod(rm)
    }

    override suspend fun insertVitalSigns(vs: VitalSign) {
        dao.insertVitalSigns(vs)
    }

    override suspend fun insertSymptom(s: Symptom) {
        dao.insertSymptom(s)
    }

    override suspend fun insertUserSymptoms(us: uSymptoms) {
        dao.insertUserSymptoms(us)
    }

    override suspend fun insertUserMeds(um: uMedications) {
        dao.insertUserMeds(um)
    }

    override suspend fun insertDoseUnits(du: DoseUnit) {
        dao.insertDoseUnits(du)
    }

    override suspend fun insertFrequencies(f: Frequency) {
        dao.insertFrequencies(f)
    }

    override suspend fun insertMedication(m: Medication) {
        dao.insertMedication(m)
    }

    override suspend fun insertAdminMethods(am: AdministrationMethod) {
        dao.insertAdminMethods(am)
    }

    override suspend fun insertRiskFactors(rf : RiskFactor) {
        dao.insertRiskFactors(rf)
    }

    override suspend fun insertUserRiskFactors(urf: uRiskFactors) {
        dao.insertUserRiskFactors(urf)
    }

    override suspend fun insertConditions(c: Condition) {
        dao.insertConditions(c)
    }

    override suspend fun insertUserConditions(uc: uConditions) {
        dao.insertUserConditions(uc)
    }


    override suspend fun updateUser(u: User) {
        dao.updateUser(u)
    }

    override suspend fun updateUserVital(uv: uVitals) {
        dao.updateUserVital(uv)
    }

    override suspend fun updateRecordingMethod(rm: RecordingMethod) {
        dao.updateRecordingMethod(rm)
    }

    override suspend fun updateVitalSigns(vs: VitalSign) {
        dao.updateVitalSigns(vs)
    }

    override suspend fun updateSymptom(s: Symptom) {
        dao.updateSymptom(s)
    }

    override suspend fun updateUserSymptoms(us: uSymptoms) {
        dao.updateUserSymptoms(us)
    }

    override suspend fun updateUserMeds(um: uMedications) {
        dao.updateUserMeds(um)
    }

    override suspend fun updateDoseUnits(du: DoseUnit) {
        dao.updateDoseUnits(du)
    }

    override suspend fun updateFrequencies(f: Frequency) {
        dao.updateFrequencies(f)
    }

    override suspend fun updateMedication(m: Medication) {
        dao.updateMedication(m)
    }

    override suspend fun updateAdminMethods(am: AdministrationMethod) {
        dao.updateAdminMethods(am)
    }

    override suspend fun updateRiskFactors(rf: RiskFactor) {
        dao.updateRiskFactors(rf)
    }

    override suspend fun updateUserRiskFactors(urf: uRiskFactors) {
        dao.updateUserRiskFactors(urf)
    }

    override suspend fun updateConditions(c: Condition) {
        dao.updateConditions(c)
    }

    override suspend fun updateUserConditions(uc: uConditions) {
        dao.updateUserConditions(uc)
    }

    override suspend fun deleteUserVital(uv: uVitals) {
        dao.deleteUserVital(uv)
    }

    override suspend fun deleteUserSymptoms(us: uSymptoms) {
        dao.deleteUserSymptoms(us)
    }

    override suspend fun deleteUserMeds(um: uMedications) {
        dao.deleteUserMeds(um)
    }

    override suspend fun deleteUserRiskFactors(urf: uRiskFactors) {
        dao.deleteUserRiskFactors(urf)
    }

    override suspend fun deleteUserConditions(uc: uConditions) {
        dao.deleteUserConditions(uc)
    }


}