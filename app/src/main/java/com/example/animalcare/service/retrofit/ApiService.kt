package com.example.animalcare.service.retrofit

import androidx.lifecycle.LiveData
import com.example.animalcare.database.daos.org_dao
import com.example.animalcare.database.entities.*
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

const val ANIMAL_CARE_API_BASE_URI = "https://animal-care.herokuapp.com/"

interface ApiService {

    @GET("/ley/")
    fun getleyes():  Deferred<Response<List<ley_entity>>>

    @GET("/ley/{articulo}")
    fun getleye(@Path("articulo")articulo:String): Deferred<Response<LiveData<List<ley_entity>>>>

    @GET("/organizacion/")
    fun getOrgs():  Deferred<Response<List<org_entity>>>

    @GET("/organizacion/{org}")
    fun getOrg(@Path("org")organizacion:String): Deferred<Response<LiveData<List<org_entity>>>>


    @GET("/enfermedad/")
    fun getEnfs():  Deferred<Response<List<enfermedad_entity>>>

    @GET("/enfermedad/{enf}")
    fun getEnf(@Path("enf")enfermedad:String): Deferred<Response<LiveData<List<enfermedad_entity>>>>

    @GET("/curiosidad/")
    fun getcuriosidades():  Deferred<Response<List<curiosidad_entity>>>

    @GET("/veterinaria/")
    fun getVets():  Deferred<Response<List<vet_entity>>>

    @GET("/veterinaria/{vet}")
    fun getVet(@Path("vet")veterinaria:String): Deferred<Response<vet_entity>>

    @GET("/especie/")
    fun getEspecies():  Deferred<Response<List<especie_entity>>>

    @GET("/especie/{esp}")
    fun getEspecieByName(@Path("esp")especie:String): Deferred<Response<LiveData<List<especie_entity>>>>

    @GET("/especie/{esp}/")
    fun getRazas(@Path("esp")especie:String):  Deferred<Response<List<Especie>>>

    @GET("/especie/raza/{raz}")
    fun getRaza(@Path("raz")raza:String): Deferred<Response<LiveData<List<raza_entity>>>>


    companion object{
        fun getAnimalService():ApiService = Retrofit.Builder()
            .baseUrl(ANIMAL_CARE_API_BASE_URI)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(ApiService::class.java)
    }
}