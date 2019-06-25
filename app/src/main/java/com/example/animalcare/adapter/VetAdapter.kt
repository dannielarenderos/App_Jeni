package com.example.animalcare.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.animalcare.R
import com.example.animalcare.activities.GlideApp
import com.example.animalcare.database.entities.vet_entity
import com.example.animalcare.fragments.vet_info_fragment
import com.example.animalcare.service.retrofit.ApiService
import kotlinx.android.synthetic.main.cardview_vet.view.*

class VetAdapter(var vets:List<vet_entity>, internal var context: Context): RecyclerView.Adapter<VetAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int):ViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview_vet,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount():Int{
        return vets.size
    }

    override fun onBindViewHolder(holder: ViewHolder,position:Int){
        holder.bind(vets[position])
        holder.setItemClickListener(View.OnClickListener {
            it.findNavController().navigate(R.id.action_fragment_Vet_to_vet_info_fragment).apply {
                val veterinaria = vets[position.toInt()].nombre_vet
                val vett:vet_entity=vets[position.toInt()]
                vet_info_fragment().bindData(veterinaria.toString(),vett)
            }

        })


    }

    fun updateList(newVet : List<vet_entity>){
        newVet.forEach{
            println("Nueva Vet")
            println(newVet.get(1).nombre_vet)
        }
        this.vets=newVet
        notifyDataSetChanged()
    }



    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){




        fun setItemClickListener(onClickListener: View.OnClickListener) {
            itemView.setOnClickListener{view -> onClickListener.onClick(view) }
        }

        fun bind(vet: vet_entity) = with(itemView){

            GlideApp.with(this)
                .load(vet.img_vet)
                .placeholder(R.drawable.ic_launcher_background)
                .into(img_vet )


            this.tv_nombreVet.text = vet.nombre_vet
            this.tv_telefonoVet.text = vet.telefono_vet
            this.tv_direccionVet.text = vet.telefono_vet





        }
    }
}
