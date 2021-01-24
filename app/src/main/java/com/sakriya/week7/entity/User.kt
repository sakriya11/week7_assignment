package com.sakriya.week7.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class  User (
    var fullName : String? = null,
    var Username : String? = null,
    var Password : String? = null,
        ){
    @PrimaryKey(autoGenerate = true)
    var userId : Int = 0
}