package edu.towson.maddox.healthhelper.db

import android.media.MediaCas
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import edu.towson.maddox.healthhelper.data.model.Converters
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

@Database(entities =
[   User::class,
    VitalSign::class,
    RecordingMethod::class,
    Symptom::class,
    uSymptoms::class,
    uVitals::class,
    RiskFactor::class,
    uRiskFactors::class,
    AdministrationMethod::class,
    DoseUnit::class,
    Frequency::class,
    Medication::class,
    uMedications::class,
    Condition::class,
    uConditions::class
                     ], version=1)
@TypeConverters(Converters::class)
abstract class DB : RoomDatabase() {
    abstract fun healthDAO() : HealthDAO
}