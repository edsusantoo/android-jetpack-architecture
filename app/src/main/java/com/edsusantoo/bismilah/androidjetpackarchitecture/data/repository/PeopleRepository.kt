package com.edsusantoo.bismilah.androidjetpackarchitecture.data.repository

import android.app.Application
import com.edsusantoo.bismilah.androidjetpackarchitecture.data.db.PeopleDatabase
import com.edsusantoo.bismilah.androidjetpackarchitecture.data.db.dao.PeopleDao
import com.edsusantoo.bismilah.androidjetpackarchitecture.data.db.model.People

class PeopleRepository(aplication:Application){
    private var peopleDao: PeopleDao? = null

    init {
        val peopleDatabase = PeopleDatabase.getInstance(aplication)
        peopleDao = peopleDatabase.peopleDao()
    }

    fun getAllPeople():List<People>{
        return peopleDao!!.getAll()
    }

    fun insertPeople(people: People){
        peopleDao!!.insert(people)
    }

    fun findPeople(id:Int):People{
        return peopleDao!!.find(id)
    }

    fun deletUserWithName(name:String){
        peopleDao!!.deleteUserWithName(name)
    }

    fun deleteAll(){
        peopleDao!!.deleteAll()
    }

}