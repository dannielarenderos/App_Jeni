package com.example.animalcare.viewModels

import android.app.Application
import android.content.Context
import androidx.lifecycle.viewModelScope
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import com.example.animalcare.database.RoomDB
import com.example.animalcare.database.entities.*
import com.example.animalcare.repositories.*
import com.example.animalcare.service.retrofit.ApiService
import com.example.animalcare.service.retrofit.Especie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelRoom(context: Application) : AndroidViewModel(context) {
    private val leyRepository: LeyRepository
    private val orgRepository: OrgRepository
    private val enfRepository: EnfRepository
    private val curRepository: CurRepository
    private val vetRepository: VetRepository
    private val razaRepository: RazaRepository


    var allLaws: LiveData<List<ley_entity>>
    val listaLeyes = MutableLiveData<MutableList<ley_entity>>()
    var allOrgs: LiveData<List<org_entity>>
    val listaOrgs = MutableLiveData<MutableList<org_entity>>()
    var allEnfs: LiveData<List<enfermedad_entity>>
    val listaEnfs = MutableLiveData<MutableList<enfermedad_entity>>()
    var allCurs: LiveData<List<curiosidad_entity>>
    val listaCurs = MutableLiveData<MutableList<curiosidad_entity>>()
    var allVets: LiveData<List<vet_entity>>
    var allRazas: LiveData<List<raza_entity>>
    val listaVets = MutableLiveData<MutableList<vet_entity>>()
    val listaTodasRazas = MutableLiveData<MutableList<raza_entity>>()
    val listaTodasEspecies = MutableLiveData<MutableList<Especie>>()



    init {
        val leyDao = RoomDB.getInstance(context, viewModelScope).leyDao()
        val orgDao = RoomDB.getInstance(context, viewModelScope).orgDao()
        val enfDao = RoomDB.getInstance(context, viewModelScope).enferDao()
        val curDao = RoomDB.getInstance(context, viewModelScope).curDao()
        val vetDao = RoomDB.getInstance(context, viewModelScope).vetDao()
        val razDao = RoomDB.getInstance(context, viewModelScope).razaDao()

        //val orgDao= RoomDB.getInstance(context).orgDao()
        //repository= Repository(orgDao, leyDao)
        orgRepository = OrgRepository(orgDao)
        leyRepository = LeyRepository(leyDao)
        enfRepository = EnfRepository(enfDao)
        curRepository = CurRepository(curDao)
        vetRepository = VetRepository(vetDao)
        razaRepository = RazaRepository(razDao)

        allOrgs = orgRepository.allOrgs
        allLaws = leyRepository.allLeyes
        allEnfs = enfRepository.allEnfermedades
        allCurs = curRepository.allCuriosidades
        allVets = vetRepository.allVets
        allRazas = razaRepository.allRazas

    }

    fun getAllLeyes() = viewModelScope.launch(Dispatchers.IO) {
        val response = leyRepository.retrieveLeyes().await()
        if (response.isSuccessful) {
            if (response.code() == 200) {
                listaLeyes.postValue(
                    response.body()?.toMutableList() ?: arrayListOf(
                        ley_entity(
                            "idDef",
                            "aparDef",
                            "artiDef"
                        )
                    )
                )
            }
        }
    }



    fun getVet(vet:String) = viewModelScope.launch(Dispatchers.IO) {
        val response = vetRepository.retrieveVet(vet).await()
        if (response.isSuccessful) {
            if (response.code() == 200) {


            }
        }
    }





    fun getAllLOrgs() = viewModelScope.launch(Dispatchers.IO) {
        val response = orgRepository.retrieveOrgs().await()
        if (response.isSuccessful) {
            if (response.code() == 200) {
                listaOrgs.postValue(
                    response.body()?.toMutableList() ?: arrayListOf(
                        org_entity(
                            "idDef",
                            "aparDef",
                            "artiDef",
                            "",
                            "k"
                        )
                    )
                )
            }
        }
    }

    fun getAllEnf() = viewModelScope.launch(Dispatchers.IO) {
        val response = enfRepository.retrieveEnfs().await()
        if (response.isSuccessful) {
            if (response.code() == 200) {
                listaEnfs.postValue(
                    response.body()?.toMutableList() ?: arrayListOf(
                        enfermedad_entity(
                            "idDef",
                            "nomDef",
                            "tipoDef",
                            "dinDef",
                            "treDif",
                            "espDif"
                        )
                    )
                )
            }
        }
    }

    fun getAllCur() = viewModelScope.launch(Dispatchers.IO) {
        val response = curRepository.retrieveCuriosidades().await()
        if (response.isSuccessful) {
            if (response.code() == 200) {
                listaCurs.postValue(
                    response.body()?.toMutableList() ?: arrayListOf(
                        curiosidad_entity(
                            "idDef",
                            "nomDef"
                        )
                    )
                )
            }
        }
    }

    fun getAllVet() = viewModelScope.launch(Dispatchers.IO) {
        val response = vetRepository.retrieveVets().await()
        if (response.isSuccessful) {
            if (response.code() == 200) {
                listaVets.postValue(
                    response.body()?.toMutableList() ?: arrayListOf(
                        vet_entity(
                            "idDef",
                            "imgDef",
                            "nomDef",
                            "telDef",
                            "dirDef"
                        )
                    )
                )
            }
        }
    }


    fun gellAllRazasPerro() = viewModelScope.launch(Dispatchers.IO) {
        val response = razaRepository.retrieveRazas("Perro").await()
        if (response.isSuccessful) {
            with(response) {
                this.body()?.forEach { specie ->
                    println(specie.nombreEspecie)
                    specie.raza.forEach { raza ->
                        println(raza.nombre_raza)
                        listaTodasEspecies.postValue(
                            response.body()?.toMutableList() ?: arrayListOf(
                                Especie(
                                    "idDef",
                                    "imgDef",
                                    specie.raza
                                )))

                        for (i in 0..specie.raza.size) {

                            listaTodasRazas.postValue(
                                response.body()?.get(0)?.raza?.toMutableList() ?: arrayListOf(
                                    raza_entity(
                                        specie.raza.get(i).id,
                                        specie.raza.get(i).img_raza,
                                        specie.raza.get(i).nombre_raza,
                                        specie.raza.get(i).origen_raza,
                                        specie.raza.get(i).descripcion_raza,
                                        specie.raza.get(i).pelo_raza,
                                        specie.raza.get(i).aseo_raza,
                                        specie.raza.get(i).tamanio_raza,
                                        specie.raza.get(i).ruidoso_raza,
                                        specie.raza.get(i).personalidad_raza,
                                        specie.raza.get(i).salud_raza,
                                        specie.raza.get(i).nutricion_raza
                                    )))
                        }} } } } }
}
