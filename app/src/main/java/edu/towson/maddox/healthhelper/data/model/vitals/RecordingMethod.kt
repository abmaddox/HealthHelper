package edu.towson.maddox.healthhelper.data.model.vitals

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recordingMethod")
data class RecordingMethod (
    @PrimaryKey(autoGenerate = true)
    val rMethod_id : Int = 0,
    val vital_id : Int,
    val method : String
        ){
    override fun toString(): String {
        return method
    }
}