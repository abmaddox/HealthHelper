package edu.towson.maddox.healthhelper.data.model.vitals

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recordingMethod")
data class RecordingMethod (
    @PrimaryKey
    val rMethod_id : Int,
    val vital_id : Int,
    val method : String
        )