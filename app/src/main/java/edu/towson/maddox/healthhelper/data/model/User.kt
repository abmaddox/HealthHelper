package edu.towson.maddox.healthhelper.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.util.*

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    val user_id : Int,
    val username : String,
    val password : String,
    val accountCreated : Date = Calendar.getInstance().time,
    val email : String?,
    val firstName : String?,
    val lastName : String?,
    val dateOfBirth : Date?,
    val lastLogin : Date?,
    val activeAccount : Boolean = true
)