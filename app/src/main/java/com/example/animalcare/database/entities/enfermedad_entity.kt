package com.example.animalcare.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json


@Entity(tableName = "enfermedad_table")
class enfermedad_entity(

    @PrimaryKey @ColumnInfo (name = "id") val id: String,
    @field:Json(name="nombre")
    @ColumnInfo(name = "nombre") val nombre_enf: String,
    @field:Json(name= "tipo")
    @ColumnInfo(name = "tipo") val tipo_enf: String,
    @field:Json(name="sintomas")
    @ColumnInfo(name = "sintomas") val sintomas_enf: String,
    @field:Json(name="tratamientos")
    @ColumnInfo(name = "tratamientos") val tratamiento_enf: String,
    @field:Json(name="especie")
    @ColumnInfo(name = "especie") val especia_enf: String

)