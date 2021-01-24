package com.sakriya.week7.dao

import androidx.room.Dao
import androidx.room.Insert
import com.sakriya.week7.entity.User
import com.sakriya.week7.model.User

@Dao
interface userDAO {
    //insert user
    @Insert
    suspend fun registerUser(user : User)


    
}