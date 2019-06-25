package com.example.animalcare.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.animalcare.database.entities.enfermedad_entity


@Dao
interface enferm_dao {
    @Query("SELECT * from enfermedad_table")
    fun getAllEnfermedades(): LiveData<List<enfermedad_entity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(enfermedad: enfermedad_entity):Long

    @Query("delete from enfermedad_table")
    suspend fun deleteAll()

}