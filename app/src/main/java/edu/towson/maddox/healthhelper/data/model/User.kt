package edu.towson.maddox.healthhelper.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    val user_id : Int = 0,
    val username : String,
    val password : String,
    val accountCreated : String = Calendar.getInstance().time.toString(),
    val email : String? = null,
    val firstName : String? = null,
    val lastName : String? = null,
    val dateOfBirth : String? = null,
    val lastLogin : String = Calendar.getInstance().time.toString(),
    val activeAccount : Boolean = true
)