package com.sakriya.week7.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.sakriya.week7.entity.User


@Dao
interface userDAO {
    //insert user
    @Insert
    suspend fun registerUser(user : User)

    @Query("select * from  User where  Username = (:username) and Password = (:password)")
    suspend fun checkUser(username : String, password: String): User


    
}