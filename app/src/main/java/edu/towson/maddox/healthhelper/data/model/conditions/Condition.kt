package edu.towson.maddox.healthhelper.data.model.conditions

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "condition")
data class Condition (
    @PrimaryKey
    val condition_id : Int,
    val conditionName : String
        )