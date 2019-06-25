package com.example.animalcare.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.animalcare.database.entities.especie_entity

@Dao
interface especie_dao {
    @Query("SELECT * from especie_table")
    fun getAllEspecies(): LiveData<List<especie_entity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(especie: especie_entity):Long

    @Query("delete from especie_table")
    suspend fun deleteAll()


}
