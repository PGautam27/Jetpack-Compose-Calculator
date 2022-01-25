package com.example.kotlincalculator.dataBase
/*
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kotlincalculator.dao.Dao1
import com.example.kotlincalculator.entity.Entity1

@Database(entities = [Entity1::class], version = 1, exportSchema = false)
abstract class DBase: RoomDatabase() {
    abstract fun Dao1(): Dao1

    companion object{
        @Volatile
        private var INSTANCE: DBase? = null

        fun getInstance(context: Context): DBase{
            val sampleInstance = INSTANCE
            if(sampleInstance!=null){
                return sampleInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DBase::class.java,
                    "database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}*/