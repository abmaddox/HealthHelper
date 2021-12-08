package edu.towson.maddox.healthhelper.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.util.*

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    val user_id : Int = 0,
    val username : String,
    val password : String,
    val accountCreated : Date = Calendar.getInstance().time,
    val email : String? = null,
    val firstName : String? = null,
    val lastName : String? = null,
    val dateOfBirth : Date? = null,
    val lastLogin : Date = Calendar.getInstance().time,
    val activeAccount : Boolean = true
)