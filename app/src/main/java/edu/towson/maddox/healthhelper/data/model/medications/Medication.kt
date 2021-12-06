package edu.towson.maddox.healthhelper.data.model.medications

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "medication")
data class Medication (
    @PrimaryKey
    val medication_id : Int,
    val brandName : String,
    val genericName : String
        )