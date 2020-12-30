package com.esiea.androide4a.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.esiea.androide4a.data.local.models.UserLocal

@Database(entities = arrayOf(
    UserLocal::class
), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao

    companion object{private var INSTANCE:AppDatabase?=null}
    fun getAppDatabase(context: Context):AppDatabase?{
        if(INSTANCE==null){
            INSTANCE= Room.databaseBuilder<AppDatabase>(context.applicationContext,AppDatabase::class.java,"MyAppBDD")
                .allowMainThreadQueries().build()
        }
        return INSTANCE
    }
    fun destroyInstance(){
        INSTANCE=null
    }
}
