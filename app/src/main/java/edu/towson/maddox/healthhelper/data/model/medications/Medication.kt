package edu.towson.maddox.healthhelper.data.model.medications

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "medication")
data class Medication (
    @PrimaryKey(autoGenerate = true)
    val medication_id : Int = 0,
    val brandName : String,
    val genericName : String?
        ){
    override fun toString(): String {
        return if (genericName != null)
            "$brandName ($genericName)"
        else
            brandName
    }
}