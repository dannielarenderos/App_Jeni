package com.example.animalcare.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "org_table")
data class org_entity (

    @PrimaryKey @ColumnInfo (name = "id") val id: String,
    @field:Json(name="nombre")
    @ColumnInfo(name = "nombre") val nombre_org: String,
    @field:Json(name="telefono")
    @ColumnInfo(name = " telefono") val telefono_org: String,
    @field:Json(name="direccion")
    @ColumnInfo(name = "direccion") val direccion_org: String,
    @field:Json(name="img")
    @ColumnInfo(name = "img") val img_org: String

    )