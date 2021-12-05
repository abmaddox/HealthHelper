package edu.towson.maddox.healthhelper.data.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vitalSign")
data class VitalSign (
    @NonNull
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val type : String, //Respiratory Rate, Blood Pressure, Heart Rate, Pulse Ox, Temperature, Height, Weight
    val unit : String,
    val minimum : Double,
    val maximum : Double
        )