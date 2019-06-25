package com.example.animalcare.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json


@Entity(tableName = "curiosidad_table")
class curiosidad_entity (
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @field:Json(name="curiosidad")
    @ColumnInfo(name = "curiosidad") val curiosidad : String
)