package com.example.animalcare.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json


@Entity(tableName = "especie_table")
class especie_entity (
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @field:Json(name="nombreEspecie")
    @ColumnInfo(name = "nombreEspecie") val nombre_especie: String,
    @field:Json(name="raza")
    @ColumnInfo(name = "raza") val  raza_especie:String
)




