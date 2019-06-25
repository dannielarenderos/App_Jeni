package com.example.animalcare.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.animalcare.database.entities.vet_entity


@Dao
interface vet_dao {
    @Query("SELECT * from vet_table")
    fun getAllVets(): LiveData<List<vet_entity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vet: vet_entity):Long

    @Query("delete from vet_table")
    suspend fun deleteAll()

}