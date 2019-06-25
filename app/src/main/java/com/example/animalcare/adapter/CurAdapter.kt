package com.example.animalcare.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.animalcare.R
import com.example.animalcare.database.entities.curiosidad_entity
import kotlinx.android.synthetic.main.cardview_curiosidades.view.*

class CurAdapter (var curiosidades:List<curiosidad_entity>): RecyclerView.Adapter<CurAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int):ViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview_curiosidades,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount():Int{
        return curiosidades.size
    }

    override fun onBindViewHolder(holder: ViewHolder,position:Int){
        holder.bind(curiosidades[position])
    }

    fun updateList(newCuriosidad : List<curiosidad_entity>){
        newCuriosidad.forEach{
            println("Nueva Curiosidad")
            println(newCuriosidad.get(1).curiosidad)
        }
        this.curiosidades=newCuriosidad
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(curiosidad: curiosidad_entity) = with(itemView){

            this.tv_curiosidad.text=curiosidad.curiosidad

        }
    }
}
