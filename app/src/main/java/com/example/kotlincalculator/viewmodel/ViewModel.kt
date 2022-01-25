package com.example.kotlincalculator.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kotlincalculator.dataBase.DBase
import com.example.kotlincalculator.entity.Entity1
import com.example.kotlincalculator.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel1(application: Application): AndroidViewModel(application) {
    val readAllData: LiveData<List<Entity1>>
    private val repository: Repository

    init {
        val dao1 = DBase.getInstance(application).Dao1()
        repository = Repository(dao1 = dao1)
        readAllData = repository.readAllData
    }

    fun addHistory(item: List<Entity1>){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addHistory(item = item)
        }
    }

    fun deleteAllRecord(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllRecord()
        }
    }
}

class ViewModelFactory(
    private val application: Application
): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if(modelClass.isAssignableFrom(ViewModel1::class.java)){
            return ViewModel1(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}