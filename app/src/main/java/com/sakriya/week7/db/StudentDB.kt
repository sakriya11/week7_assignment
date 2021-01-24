package com.sakriya.week7.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sakriya.week7.dao.userDAO
import com.sakriya.week7.entity.user

@Database(
    entities = [(user::class)], //class haru add garne eta
    version = 1
)
abstract class StudentDB : RoomDatabase(){

    abstract fun getUserDAO() : userDAO

    companion object{ //everything is static inside companion object

        @Volatile
        private var instance :StudentDB? = null

        fun getInstance (context: Context) : StudentDB{
            if (instance == null){
                synchronized(StudentDB::class){

                    instance = buildDatabase(context)
                }
            }

            return instance!!
        }

        private fun buildDatabase(context: Context) :StudentDB{
            return   Room.databaseBuilder(context.applicationContext,
                StudentDB::class.java,
                "StudentDatabase").build()
        }


    }


}