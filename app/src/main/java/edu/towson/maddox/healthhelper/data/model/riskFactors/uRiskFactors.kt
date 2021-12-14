package edu.towson.maddox.healthhelper.data.model.riskFactors

import androidx.room.Entity
import java.util.*

@Entity(primaryKeys = ["user_id", "factor_id","timestamp"])
class uRiskFactors (
    val user_id : Int,
    val factor_id : Int,
    val timestamp : String = Calendar.getInstance().time.toString()
        )