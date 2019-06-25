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
import com.example.animalcare.adapter.EnfAdapter
import com.example.animalcare.viewModels.ViewModelRoom

private lateinit var recyclerView_: RecyclerView
class Enfermedades : Fragment() {

    lateinit var viewModel: ViewModelRoom
    lateinit var enfAdapter: EnfAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_enfermedades, container, false)
        recyclerView_ = view.findViewById(R.id.rv_enfermedades)
        enfAdapter = EnfAdapter(emptyList())

        recyclerView_.apply {
            layoutManager = LinearLayoutManager(this@Enfermedades.context)
            adapter = enfAdapter
        }


        viewModel = ViewModelProviders.of(this).get(ViewModelRoom::class.java)
        viewModel.getAllEnf()
        viewModel.listaEnfs.observe(this, Observer { listaEnfs ->
            enfAdapter.updateList(listaEnfs)
            for (enfermedad in listaEnfs) {
                Log.v("Enfermedad", enfermedad.nombre_enf)
            }
        })
        return view
    }
}

