package com.edsusantoo.bismilah.androidjetpackarchitecture.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.edsusantoo.bismilah.androidjetpackarchitecture.data.db.model.People

@Dao
interface PeopleDao {

    // Select All
    @Query("SELECT * FROM People ORDER BY id DESC")
    fun getAll(): List<People>

    // Insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(people: People)

    // Delete
    @Query("DELETE FROM People")
    fun deleteAll()

    // Select By Id
    @Query("SELECT * FROM People WHERE id=:id")
    fun find(id: Int): People

    // Delete By Name
    @Query("DELETE FROM People WHERE name=:name")
    fun deleteUserWithName(name: String)
}