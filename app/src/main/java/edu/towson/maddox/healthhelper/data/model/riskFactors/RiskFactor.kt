package edu.towson.maddox.healthhelper.data.model.riskFactors

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "riskFactor")
data class RiskFactor(
    @PrimaryKey(autoGenerate = true)
    val factor_id : Int = 0,
    val factorName : String
){
    override fun toString(): String {
        return factorName
    }
}