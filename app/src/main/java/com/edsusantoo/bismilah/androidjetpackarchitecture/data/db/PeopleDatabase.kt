package com.edsusantoo.bismilah.androidjetpackarchitecture.data.db

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.edsusantoo.bismilah.androidjetpackarchitecture.data.db.dao.PeopelDao
import com.edsusantoo.bismilah.androidjetpackarchitecture.data.db.model.People


@Database(entities = [People::class], version = 1)
abstract class PeopleDatabase : RoomDatabase() {
    abstract fun peopleDao(): PeopelDao

    companion object {
        private val lock = Any()
        private const val DB_NAME = "People.db"
        private var INSTANCE: PeopleDatabase? = null
    }

    fun getInstance(application: Application): PeopleDatabase {
        synchronized(lock) {
            if (INSTANCE == null) {
                INSTANCE =
                        Room.databaseBuilder(application, PeopleDatabase::class.java, DB_NAME).allowMainThreadQueries()
                            .build()
            }
            return INSTANCE!!
        }
    }

}