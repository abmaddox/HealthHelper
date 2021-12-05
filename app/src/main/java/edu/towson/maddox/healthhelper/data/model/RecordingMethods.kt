package edu.towson.maddox.healthhelper.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recordingMethod")
data class RecordingMethods (
    @PrimaryKey
    val id : Int,
    val vital_id : Int,
    val method : String
        )