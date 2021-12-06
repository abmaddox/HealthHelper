package edu.towson.maddox.healthhelper.data.model.medications

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "administrationMethod")
data class AdministrationMethod (
    @PrimaryKey
    val method_id : Int,
    val code : String
        )