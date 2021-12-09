package edu.towson.maddox.healthhelper.data.model.conditions

import androidx.room.Entity
import java.util.*

@Entity(primaryKeys = ["user_id","condition_id"])
data class uConditions(
    val user_id : Int,
    val condition_id : Int,
    val startDate: String?,
    val endDate: String?
)