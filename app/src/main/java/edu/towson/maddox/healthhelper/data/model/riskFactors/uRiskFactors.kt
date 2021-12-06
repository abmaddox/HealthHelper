package edu.towson.maddox.healthhelper.data.model.riskFactors

import androidx.room.Entity

@Entity(primaryKeys = ["user_id", "factor_id"])
class uRiskFactors (
    val user_id : Int,
    val factor_id : Int
        )