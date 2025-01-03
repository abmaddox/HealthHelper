package edu.towson.maddox.healthhelper.data.model.vitals

import androidx.room.Entity
import java.util.*

@Entity(primaryKeys = ["user_id", "vital_id", "rMethod_id","timestamp","measurement"])
data class uVitals (
    val user_id : Int,
    val vital_id : Int,
    val rMethod_id : Int,
    val timestamp : String = Calendar.getInstance().time.toString(),
    val measurement: Double
)