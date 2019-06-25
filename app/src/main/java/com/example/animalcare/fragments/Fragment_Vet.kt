package com.example.animalcare.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animalcare.R
import com.example.animalcare.adapter.OrgAdapter
import com.example.animalcare.adapter.VetAdapter
import com.example.animalcare.viewModels.ViewModelRoom


private lateinit var recyclerView_: RecyclerView
class Fragment_Vet : Fragment()  {


    private lateinit var vetViewModel: ViewModelRoom
    private lateinit var vetAdapter: VetAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_vet, container, false)
        recyclerView_= view.findViewById(R.id.rv_vet)
        vetAdapter = VetAdapter(emptyList(),activity!!)

        recyclerView_.apply {
            layoutManager = LinearLayoutManager(this@Fragment_Vet.context)
            adapter = vetAdapter
        }


        vetViewModel = ViewModelProviders.of(this).get(ViewModelRoom::class.java)
        vetViewModel.getAllVet()
        vetViewModel.listaVets.observe(this, Observer { listaVets ->
            vetAdapter.updateList(listaVets)
            for (vet in listaVets) {
                Log.v("Vet", vet.nombre_vet)
            }
        })
        return view


    }
}
