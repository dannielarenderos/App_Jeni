package com.example.animalcare.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.animalcare.database.entities.raza_entity


@Dao
interface raza_dao {


    @Query("SELECT * from raza_table")
    fun getAllRazas(): LiveData<List<raza_entity>>

    @Query("SELECT * from raza_table where nombre = :nom")
    fun getRazaByNme(nom:String): LiveData<raza_entity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRaza(raz:raza_entity):Long

    @Query("delete from raza_table")
    suspend fun deleteAll()


}