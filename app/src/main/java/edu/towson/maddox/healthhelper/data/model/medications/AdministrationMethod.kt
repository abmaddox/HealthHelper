package edu.towson.maddox.healthhelper.data.model.medications

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "administrationMethod")
data class AdministrationMethod (
    @PrimaryKey(autoGenerate = true)
    val method_id : Int = 0,
    val code : String
        ){
    override fun toString(): String {
        return code
    }
}