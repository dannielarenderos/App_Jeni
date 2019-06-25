package com.example.animalcare.repositories

import androidx.lifecycle.LiveData
import com.example.animalcare.database.daos.vet_dao
import com.example.animalcare.database.entities.vet_entity
import com.example.animalcare.service.retrofit.ApiService
import kotlinx.coroutines.Deferred
import retrofit2.Response

class VetRepository (private val vetDao: vet_dao) {


    val allVets: LiveData<List<vet_entity>> = vetDao.getAllVets()

    fun retrieveVets(): Deferred<Response<List<vet_entity>>> {
        return ApiService.getAnimalService().getVets()
    }

    fun retrieveVet(vet: String) : Deferred<Response<vet_entity>>{
        return ApiService.getAnimalService().getVet(vet)
    }

}