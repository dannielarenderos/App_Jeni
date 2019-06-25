package com.example.animalcare.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json


@Entity(tableName = "vet_table")
class vet_entity(
    @PrimaryKey @ColumnInfo(name = "id") val id: String="N/a",
    @field:Json(name="img")
    @ColumnInfo(name = "img") val img_vet : String="N/a",
    @field:Json(name="nombre")
    @ColumnInfo(name = "nombre") val nombre_vet : String="N/a",
    @field:Json(name="telefono")
    @ColumnInfo(name = "telefono") val telefono_vet : String="N/a",
    @field:Json(name="direccion")
    @ColumnInfo(name = "direccion") val direccion_vet : String="N/a"
)