package edu.towson.maddox.healthhelper.data.model.medications

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "doseUnit")
data class DoseUnit (
    @PrimaryKey
    val unit_id : Int,
    val unit : String
        )