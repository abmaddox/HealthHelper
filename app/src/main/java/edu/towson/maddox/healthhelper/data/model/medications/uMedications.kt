package edu.towson.maddox.healthhelper.data.model.medications

import androidx.room.Entity

@Entity(primaryKeys = ["user_id", "medication_id", "frequency_id", "method_id", "unit_id"])
data class uMedications (
    val user_id : Int,
    val medication_id : Int,
    val frequency_id : Int,
    val method_id : Int,
    val unit_id : Int,
    val startDate: String,
    val endDate: String,
    val reason : String = "",
    val dosage : Double
    )