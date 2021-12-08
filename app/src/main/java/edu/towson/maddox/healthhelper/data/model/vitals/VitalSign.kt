package edu.towson.maddox.healthhelper.data.model.vitals

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "vitalSign")
data class VitalSign (
    @PrimaryKey(autoGenerate = true)
    val vital_id : Int = 0,
    val type : String, //Respiratory Rate, Blood Pressure, Heart Rate, Pulse Ox, Temperature, Height, Weight
    val unit : String,
    val minimum : Double,
    val maximum : Double
        ){
    override fun toString(): String {
        return type
    }
}