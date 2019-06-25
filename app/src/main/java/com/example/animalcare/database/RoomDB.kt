package com.example.animalcare.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.animalcare.database.daos.*
import com.example.animalcare.database.entities.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [ley_entity::class, org_entity::class, enfermedad_entity::class ,curiosidad_entity::class ,vet_entity::class,raza_entity::class,especie_entity::class], version = 4, exportSchema = false)
public abstract class RoomDB : RoomDatabase() {
    abstract fun leyDao(): ley_dao
    abstract fun orgDao(): org_dao
    abstract fun enferDao():enferm_dao
    abstract fun curDao():cur_dao
    abstract fun vetDao():vet_dao
    abstract fun razaDao():raza_dao
    abstract fun especieDao():especie_dao


    companion object {
        @Volatile
        private var INSTANCE: RoomDB? = null

        fun getInstance(context: Context, scope: CoroutineScope): RoomDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context, RoomDB::class.java, "animals")
                    .fallbackToDestructiveMigration()
                    .addCallback(RoomDBCallback(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

    private class RoomDBCallback(private val scope: CoroutineScope) : RoomDatabase.Callback() {
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch(Dispatchers.IO) {
                    populateDB(database.leyDao(), database.orgDao(),database.enferDao(),database.curDao(),database.vetDao(),database.razaDao(),database.especieDao())
                }
            }
        }

        suspend fun populateDB(
            leyDao: ley_dao,
            orgDao: org_dao,
            enferDao:enferm_dao,
            curDao:cur_dao,
            vetDao:vet_dao,
            razaDao:raza_dao,
            especieDao:especie_dao

        ) {
            leyDao.deleteAll()
            orgDao.deleteAll()
            enferDao.deleteAll()
            curDao.deleteAll()
            vetDao.deleteAll()
            razaDao.deleteAll()
            especieDao.deleteAll()


        }
    }
}