package edu.towson.maddox.healthhelper.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import edu.towson.maddox.healthhelper.data.model.Converters
import edu.towson.maddox.healthhelper.data.model.User
import edu.towson.maddox.healthhelper.data.model.VitalSign

@Database(entities = [User::class, VitalSign::class], version=1)
@TypeConverters(Converters::class)
abstract class DB : RoomDatabase() {
    abstract fun healthDAO() : HealthDAO
}