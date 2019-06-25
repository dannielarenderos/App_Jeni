package com.example.animalcare.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.animalcare.database.entities.ley_entity
import androidx.room.Query
import com.example.animalcare.database.entities.org_entity

@Dao
interface org_dao {


    @Query("SELECT * from org_table")
    fun getAllOrgs(): LiveData<List<org_entity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrg(org:org_entity):Long

    @Query("delete from org_table")
    suspend fun deleteAll()


    @Query("SELECT * from org_table where nombre = :org")
    fun getOrg(org:String): LiveData<org_entity>

}