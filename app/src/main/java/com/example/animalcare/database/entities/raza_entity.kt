package com.example.animalcare.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "raza_table")

class raza_entity (
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @field:Json(name="img")
    @ColumnInfo(name = "img") val img_raza : String,
    @field:Json(name="nombre")
    @ColumnInfo(name = "nombre") val nombre_raza : String,
    @field:Json(name="origen")
    @ColumnInfo(name = "origen") val origen_raza : String,
    @field:Json(name="descripcion")
    @ColumnInfo(name = "descripcion") val descripcion_raza : String,
    @field:Json(name="pelo")
    @ColumnInfo(name = "pelo") val pelo_raza : String,
    @field:Json(name="aseo")
    @ColumnInfo(name = "aseo") val aseo_raza : String,
    @field:Json(name="tamanio")
    @ColumnInfo(name = "tamanio") val tamanio_raza : String,
    @field:Json(name="ruidoso")
    @ColumnInfo(name = "ruidoso") val ruidoso_raza : String,
    @field:Json(name="personalidad")
    @ColumnInfo(name = "personalidad") val personalidad_raza : String,
    @field:Json(name="salud")
    @ColumnInfo(name = "salud") val salud_raza : String,
    @field:Json(name="nutricion")
    @ColumnInfo(name = "nutricion") val nutricion_raza : String
)