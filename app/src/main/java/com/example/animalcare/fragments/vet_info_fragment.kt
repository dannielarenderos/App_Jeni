package com.example.animalcare.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.animalcare.R
import com.example.animalcare.adapter.VetAdapter
import com.example.animalcare.database.entities.vet_entity
import com.example.animalcare.service.retrofit.ApiService
import kotlinx.android.synthetic.main.cardview_vet.view.*
import kotlinx.android.synthetic.main.fragment_vet_info.*

class vet_info_fragment() : Fragment() {


    private lateinit var vetAdapter: VetAdapter



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.fragment_vet_info, container, false)




        return view
    }


    fun  bindData(vete: String,vet:vet_entity){

        ApiService.getAnimalService().getVet(vete)
        Glide.with(this)
            .load(vet.img_vet)
            .placeholder(R.drawable.ic_launcher_background)
            .into(img_vet)



        this.tv_nombreVet.text = vet.nombre_vet
        this.tv_telefonoVet.text = vet.telefono_vet
        this.tv_direccionVet.text = vet.telefono_vet





    }



}
