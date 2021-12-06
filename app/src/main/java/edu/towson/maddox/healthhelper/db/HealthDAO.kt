package edu.towson.maddox.healthhelper.db

import androidx.room.*
import edu.towson.maddox.healthhelper.data.model.vitals.RecordingMethod

@Dao
interface HealthDAO {
    @Transaction
    @Query("SELECT * FROM vitalSign")
    fun getVitalsWithMethods(): List<RecordingMethod>
}