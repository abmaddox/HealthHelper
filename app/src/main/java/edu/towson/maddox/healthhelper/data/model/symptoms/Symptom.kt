package edu.towson.maddox.healthhelper.data.model.symptoms

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "symptom")
data class Symptom (
    @PrimaryKey
    val symptom_id : Int,
    val symptomName : String
        )
