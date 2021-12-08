package edu.towson.maddox.healthhelper.data.model.medications

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "doseUnit")
data class DoseUnit (
    @PrimaryKey(autoGenerate = true)
    val unit_id : Int = 0,
    val unit : String
        ){
    override fun toString(): String {
        return unit
    }
}