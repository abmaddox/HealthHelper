package edu.towson.maddox.healthhelper.data.model.medications

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "frequency")
data class Frequency (
    @PrimaryKey(autoGenerate = true)
    val frequency_id : Int = 0,
    val code : String
){
    override fun toString(): String {
        return code
    }
}