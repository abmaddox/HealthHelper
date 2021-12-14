package edu.towson.maddox.healthhelper.data.model.conditions

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "condition")
data class Condition (
    @PrimaryKey(autoGenerate = true)
    val condition_id : Int = 0,
    val conditionName : String
        )
{
    override fun toString(): String
    {
        return conditionName
    }
}