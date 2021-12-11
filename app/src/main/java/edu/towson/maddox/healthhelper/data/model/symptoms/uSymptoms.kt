package edu.towson.maddox.healthhelper.data.model.symptoms

import androidx.room.Entity

@Entity(primaryKeys = ["user_id", "symptom_id"])
data class uSymptoms (
    val user_id : Int,
    val symptom_id : Int,
    val startDate: String,
    val endDate: String
        )
