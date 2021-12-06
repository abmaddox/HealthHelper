package edu.towson.maddox.healthhelper.data.model.medications

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "frequency")
data class Frequency (
    @PrimaryKey
    val frequency_id : Int,
    val code : String
)