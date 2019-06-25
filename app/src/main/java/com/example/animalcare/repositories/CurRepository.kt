package com.example.animalcare.repositories

import androidx.lifecycle.LiveData
import com.example.animalcare.database.daos.cur_dao
import com.example.animalcare.database.entities.curiosidad_entity
import com.example.animalcare.service.retrofit.ApiService
import kotlinx.coroutines.Deferred
import retrofit2.Response

class CurRepository (private val curDao: cur_dao) {


    val allCuriosidades: LiveData<List<curiosidad_entity>> = curDao.getAllCuriosidades()

    fun retrieveCuriosidades(): Deferred<Response<List<curiosidad_entity>>> {
        return ApiService.getAnimalService().getcuriosidades()
    }
}