package com.example.kotlincalculator.repository

import androidx.lifecycle.LiveData
import com.example.kotlincalculator.dao.Dao1
import com.example.kotlincalculator.entity.Entity1

class Repository(private val dao1: Dao1) {
    val readAllData: LiveData<List<Entity1>> = dao1.getAllData()

    suspend fun addHistory(item: List<Entity1>){
        dao1.insert(item)
    }

    suspend fun deleteAllRecord(){
        dao1.deleteAllRecord()
    }
}