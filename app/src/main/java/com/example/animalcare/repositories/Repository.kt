/**package com.example.animalcare.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.animalcare.database.daos.ley_dao
import com.example.animalcare.database.daos.org_dao
import com.example.animalcare.database.entities.ley_entity
import com.example.animalcare.database.entities.org_entity
import com.example.animalcare.service.retrofit.ApiService
import kotlinx.coroutines.Deferred
import retrofit2.Response

class Repository(private val orgDao: org_dao, private val leyDao: ley_dao) {


    fun getAllLeyes(): LiveData<List<ley_entity>> {
        return leyDao.getAllLeyes()
    }

    fun getLey(ley: String): LiveData<ley_entity> {
        return leyDao.getLey(ley)
    }


    fun getAllOrg(): LiveData<List<org_entity>> {
        return orgDao.getAllOrgs()
    }

    fun getorg(org: String): LiveData<org_entity> {
        return orgDao.getOrg(org)
    }




    fun retrieveLey(ley:String): Deferred<Response<LiveData<List<ley_entity>>>> {
        return ApiService.getRetrofit().getleye(ley)
    }


    fun retrieveOrg(org:String): Deferred<Response<LiveData<List<org_entity>>>> {
        return ApiService.getRetrofit().getorg(org)
    }


    fun retrieveLeyes(): Deferred<Response<LiveData<ley_entity>>> {
        return ApiService.getRetrofit().getleyes()
    }


    fun retrieveOrgs(): Deferred<Response<LiveData<org_entity>>> {
        return ApiService.getRetrofit().getorgs()
    }


}
 **/