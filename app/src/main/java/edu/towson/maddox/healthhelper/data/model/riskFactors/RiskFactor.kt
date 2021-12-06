package edu.towson.maddox.healthhelper.data.model.riskFactors

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "riskFactor")
data class RiskFactor(
    @PrimaryKey
    val factor_id : Int,
    val factorName : String
)