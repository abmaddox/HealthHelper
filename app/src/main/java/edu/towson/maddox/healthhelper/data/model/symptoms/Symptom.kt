package edu.towson.maddox.healthhelper.data.model.symptoms

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "symptom")
data class Symptom (
    @PrimaryKey(autoGenerate = true)
    val symptom_id : Int = 0,
    val symptomName : String
        ){
    override fun toString(): String {
        return symptomName
    }
}
