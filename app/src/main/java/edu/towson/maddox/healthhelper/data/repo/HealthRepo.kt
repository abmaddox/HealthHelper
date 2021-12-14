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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


class HealthRepo (private val dao : HealthDAO, private val scope: CoroutineScope) : IHealthRepo {

    private var userId : Int? = null

    private var conditions : List<Condition> = listOf()
    private var adminMethods : List<AdministrationMethod> = listOf()
    private var doseUnits : List<DoseUnit> = listOf()
    private var frequencies : List<Frequency> = listOf()
    private var medications : List<Medication> = listOf()
    private var riskFactors : List<RiskFactor> = listOf()
    private var symptoms : List<Symptom> = listOf()
    private var recordingMethods : List<RecordingMethod> = listOf()
    private var vitalSigns : List<VitalSign> = listOf()

    private var userConditions : List<uConditions> = listOf()
    private var userMedications : List<uMedications> = listOf()
    private var userRiskFactors : List<uRiskFactors> = listOf()
    private var userSymptoms : List<uSymptoms> = listOf()
    private var userVitalSigns : List<uVitals> = listOf()
    private var waiting : Boolean = true
    init
    {
        scope.launch {
            loadDefaults()
        }
    }

    override suspend fun loadDefaults()
    {
        setAdminMethods()
        setConditions()
        setDoseUnits()
        setFrequencies()
        setMedication()
        setRecordingMethods()
        setRiskFactors()
        setSymptoms()
        setVitalSigns()
    }

    override fun loadUserItems()
    {
        scope.launch{
            setUserConditions()
            setUserMeds()
            setUserRiskFactors()
            setUserSymptoms()
            setUserVitals()
        }
    }

    override fun returnUserId() : Int
    {
        return userId!!
    }

    override fun getUserVitals(): List<uVitals>
    {
        return userVitalSigns
    }

    override fun getRecordingMethods(): List<RecordingMethod>
    {
        return recordingMethods
    }

    override fun getVitalSigns(): List<VitalSign>
    {
        return vitalSigns
    }

    override fun getSymptoms(): List<Symptom>
    {
        return symptoms
    }

    override fun getUserSymptoms(): List<uSymptoms>
    {
        return userSymptoms
    }

    override fun getUserMeds(): List<uMedications>
    {
        return userMedications
    }

    override fun getDoseUnits(): List<DoseUnit>
    {
        return doseUnits
    }

    override fun getFrequencies(): List<Frequency>
    {
        return frequencies
    }

    override fun getMedication(): List<Medication>
    {
        return medications
    }

    override fun getAdminMethods(): List<AdministrationMethod>
    {
        return adminMethods
    }

    override fun getRiskFactors(): List<RiskFactor>
    {
        return riskFactors
    }

    override fun getUserRiskFactors(): List<uRiskFactors>
    {
        return userRiskFactors
    }

    override fun getConditions(): List<Condition>
    {
        return conditions
    }

    override fun getUserConditions(): List<uConditions>
    {
        return userConditions
    }

    override fun setUserId(i : Int)
    {
        userId = i
    }

    override suspend fun getUserId(username : String, password : String): Int? {
        userId = dao.getUserId(username, password)
        return userId
    }

    override suspend fun setUserVitals(){
        userVitalSigns =  dao.getUserVitals(userId!!)
    }

    override suspend fun setRecordingMethods() {
        recordingMethods = dao.getRecordingMethods()
    }

    override suspend fun setVitalSigns() {
        vitalSigns = dao.getVitalSigns()
    }

    override suspend fun setSymptoms() {
        symptoms = dao.getSymptoms()
    }

    override suspend fun setUserSymptoms() {
        userSymptoms = dao.getUserSymptoms(userId!!)
    }

    override suspend fun setUserMeds() {
        userMedications = dao.getUserMeds(userId!!)
    }

    override suspend fun setDoseUnits() {
        doseUnits = dao.getDoseUnits()
    }

    override suspend fun setFrequencies() {
        frequencies = dao.getFrequencies()
    }

    override suspend fun setMedication() {
        medications = dao.getMedication()
    }

    override suspend fun setAdminMethods() {
        adminMethods = dao.getAdminMethods()
    }

    override suspend fun setRiskFactors() {
        riskFactors = dao.getRiskFactors()
    }

    override suspend fun setUserRiskFactors() {
        userRiskFactors = dao.getUserRiskFactors(userId!!)
    }

    override suspend fun setConditions(){
        conditions = dao.getConditions()
    }

    override suspend fun setUserConditions(){
        userConditions = dao.getUserConditions(userId!!)
    }

    override suspend fun insertDummyValues()
    {
        insertSymptom(Symptom(symptomName = "Cough"))
        insertSymptom(Symptom(symptomName = "Fever"))
        insertSymptom(Symptom(symptomName = "Indigestion"))

        insertConditions(Condition(conditionName = "Asthma"))
        insertConditions(Condition(conditionName = "GERD"))
        insertConditions(Condition(conditionName = "Insomnia"))

        insertAdminMethods(AdministrationMethod(1 , code = "P.O."))
        insertAdminMethods(AdministrationMethod(2 , code = "I.M."))
        insertAdminMethods(AdministrationMethod( 3, code = "Subq."))
        insertAdminMethods(AdministrationMethod( 4, code = "Rectally"))
        insertAdminMethods(AdministrationMethod(5 , code = "I.V."))
        insertAdminMethods(AdministrationMethod( 6, code = "O.D."))
        insertAdminMethods(AdministrationMethod(7 , code = "O.S."))
        insertAdminMethods(AdministrationMethod( 8, code = "O.U."))

        insertFrequencies(Frequency(1 , code = "q.d."))
        insertFrequencies(Frequency( 2, code = "b.i.d."))
        insertFrequencies(Frequency( 3, code = "t.i.d."))
        insertFrequencies(Frequency( 4, code = "q.i.d."))
        insertFrequencies(Frequency(5 , code = "q.h.s."))
        insertFrequencies(Frequency( 6, code = "5X a day"))
        insertFrequencies(Frequency( 7, code = "q.4h"))
        insertFrequencies(Frequency( 8, code = "q.6h"))
        insertFrequencies(Frequency( 9, code = "q.o.d."))
        insertFrequencies(Frequency( 10, code = "prn"))
        insertFrequencies(Frequency( 11, code = "a.c."))
        insertFrequencies(Frequency( 12, code = "p.c."))

        insertVitalSigns(VitalSign(1, type="Respiratory Rate", unit = "breaths per minute", minimum = 0.0, maximum = 100.0))
        insertVitalSigns(VitalSign(2, type="Systolic Blood Pressure", unit = "mmHg", minimum = 0.0, maximum = 400.0))
        insertVitalSigns(VitalSign(3, type="Heart Rate", unit = "beats per minute", minimum = 0.0, maximum = 400.0))
        insertVitalSigns(VitalSign(4, type="Pulse Oximetry", unit = "percent", minimum = 0.0, maximum = 100.0))
        insertVitalSigns(VitalSign(5, type="Temperature", unit = "degrees F", minimum = 0.0, maximum = 110.0))
        insertVitalSigns(VitalSign(6, type="Height", unit = "inches", minimum = 0.0, maximum = 120.0))
        insertVitalSigns(VitalSign(7, type="Weight", unit = "pounds", minimum = 0.0, maximum = 1500.0))

        insertRecordingMethod(RecordingMethod(vital_id = 1, method = "full minute count"))
        insertRecordingMethod(RecordingMethod(vital_id = 1, method = "10 second count X 6"))
        insertRecordingMethod(RecordingMethod(vital_id = 2, method = "wrist sitting"))
        insertRecordingMethod(RecordingMethod(vital_id = 2, method = "wrist standing"))
        insertRecordingMethod(RecordingMethod(vital_id = 2, method = "wrist lying down"))
        insertRecordingMethod(RecordingMethod(vital_id = 2, method = "arm sitting"))
        insertRecordingMethod(RecordingMethod(vital_id = 2, method = "arm standing"))
        insertRecordingMethod(RecordingMethod(vital_id = 2, method = "arm lying down"))
        insertRecordingMethod(RecordingMethod(vital_id = 2, method = "calf sitting"))
        insertRecordingMethod(RecordingMethod(vital_id = 2, method = "calf standing"))
        insertRecordingMethod(RecordingMethod(vital_id = 2, method = "calf lying down"))
        insertRecordingMethod(RecordingMethod(vital_id = 2, method = "ankle sitting"))
        insertRecordingMethod(RecordingMethod(vital_id = 2, method = "ankle standing"))
        insertRecordingMethod(RecordingMethod(vital_id = 2, method = "ankle lying down"))
        insertRecordingMethod(RecordingMethod(vital_id = 3, method = "neck resting"))
        insertRecordingMethod(RecordingMethod(vital_id = 3, method = "neck active"))
        insertRecordingMethod(RecordingMethod(vital_id = 3, method = "wrist resting"))
        insertRecordingMethod(RecordingMethod(vital_id = 3, method = "wrist active"))
        insertRecordingMethod(RecordingMethod(vital_id = 3, method = "popliteal resting"))
        insertRecordingMethod(RecordingMethod(vital_id = 3, method = "popliteal active"))
        insertRecordingMethod(RecordingMethod(vital_id = 3, method = "groin resting"))
        insertRecordingMethod(RecordingMethod(vital_id = 3, method = "groin active"))
        insertRecordingMethod(RecordingMethod(vital_id = 3, method = "brachial resting"))
        insertRecordingMethod(RecordingMethod(vital_id = 3, method = "brachial active"))
        insertRecordingMethod(RecordingMethod(vital_id = 3, method = "pedal resting"))
        insertRecordingMethod(RecordingMethod(vital_id = 3, method = "pedal active"))
        insertRecordingMethod(RecordingMethod(vital_id = 3, method = "direct auscultation resting"))
        insertRecordingMethod(RecordingMethod(vital_id = 3, method = "direct auscultation resting"))
        insertRecordingMethod(RecordingMethod(vital_id = 4, method = "finger"))
        insertRecordingMethod(RecordingMethod(vital_id = 4, method = "forehead"))
        insertRecordingMethod(RecordingMethod(vital_id = 4, method = "nose"))
        insertRecordingMethod(RecordingMethod(vital_id = 4, method = "foot"))
        insertRecordingMethod(RecordingMethod(vital_id = 4, method = "ear"))
        insertRecordingMethod(RecordingMethod(vital_id = 4, method = "toe"))
        insertRecordingMethod(RecordingMethod(vital_id = 5, method = "Rectal"))
        insertRecordingMethod(RecordingMethod(vital_id = 5, method = "Oral"))
        insertRecordingMethod(RecordingMethod(vital_id = 5, method = "Axillary"))
        insertRecordingMethod(RecordingMethod(vital_id = 5, method = "Tympanic"))
        insertRecordingMethod(RecordingMethod(vital_id = 5, method = "Temporal"))
        insertRecordingMethod(RecordingMethod(vital_id = 6, method = "tape measure or ruler"))
        insertRecordingMethod(RecordingMethod(vital_id = 7, method = "digital scale"))
        insertRecordingMethod(RecordingMethod(vital_id = 7, method = "mechanical scale"))

        insertDoseUnits(DoseUnit(unit = "kg"))
        insertDoseUnits(DoseUnit(unit = "g"))
        insertDoseUnits(DoseUnit(unit = "mg"))
        insertDoseUnits(DoseUnit(unit = "mcg"))
        insertDoseUnits(DoseUnit(unit = "ng"))
        insertDoseUnits(DoseUnit(unit = "L"))
        insertDoseUnits(DoseUnit(unit = "mL"))
        insertDoseUnits(DoseUnit(unit = "cc"))
        insertDoseUnits(DoseUnit(unit = "mol"))
        insertDoseUnits(DoseUnit(unit = "mmol"))

        insertMedication(Medication(brandName = "Lipitor", genericName = "Atorvastatin"))
        insertMedication(Medication(brandName = "Synthroid/ Levothroid/ Levoxyl/ Unithroid", genericName = "Levothyroxine"))
        insertMedication(Medication(brandName = "Zestril/ Prinivil", genericName = "Lisinopril"))
        insertMedication(Medication(brandName = "Fortamet/ Glucophage/ Glumetza/ Riomet", genericName = "Metformin"))

        insertRiskFactors(RiskFactor(factorName = "Tobacco smoking"))
        insertRiskFactors(RiskFactor(factorName = "Excessive alcohol consumption"))
        insertRiskFactors(RiskFactor(factorName = "Poor nutrition"))
        insertRiskFactors(RiskFactor(factorName = "Insufficient physical activity"))
        insertRiskFactors(RiskFactor(factorName = "Obesity"))
        insertRiskFactors(RiskFactor(factorName = "High blood pressure"))

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

    override fun addUserVitals(uv: uVitals)
    {
       userVitalSigns = listOf(uv) + userVitalSigns
    }

    override fun addUserSymptoms(us: uSymptoms)
    {
        userSymptoms = listOf(us) + userSymptoms
    }

    override fun addUserMeds(umed: uMedications)
    {
        userMedications = listOf(umed) + userMedications
    }

    override fun addUserRiskFactors(urf: uRiskFactors)
    {
        userRiskFactors = listOf(urf) + userRiskFactors
    }

    override fun addUserConditions(uc: uConditions)
    {
        userConditions = listOf(uc) + userConditions
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