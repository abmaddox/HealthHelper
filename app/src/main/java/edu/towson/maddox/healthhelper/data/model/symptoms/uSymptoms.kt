package edu.towson.maddox.healthhelper.data.model.symptoms

import androidx.room.Entity
import java.util.*

@Entity(primaryKeys = ["user_id", "symptom_id"])
data class uSymptoms (
    val user_id : Int,
    val symptom_id : Int,
    val startDate: String,
    val endDate: String,
    val timestamp : String = Calendar.getInstance().time.toString()
        )
