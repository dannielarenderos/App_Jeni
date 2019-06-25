package com.example.animalcare.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.lifecycle.Observer
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animalcare.R
import com.example.animalcare.adapter.LeyAdapter
import com.example.animalcare.viewModels.ViewModelRoom


private lateinit var recyclerView_: RecyclerView

class fragment_leyes : Fragment() {

    lateinit var viewModel: ViewModelRoom
    lateinit var leyAdapter: LeyAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_laws, container, false)
        recyclerView_ = view.findViewById(R.id.rv_leyesMainAct)
        leyAdapter = LeyAdapter(emptyList())

        recyclerView_.apply {
            layoutManager = LinearLayoutManager(this@fragment_leyes.context)
            adapter = leyAdapter
        }


        viewModel = ViewModelProviders.of(this).get(ViewModelRoom::class.java)
        viewModel.getAllLeyes()
        viewModel.listaLeyes.observe(this, Observer { listaDeLeyes ->
            leyAdapter.updateList(listaDeLeyes)
            for (ley in listaDeLeyes) {
                Log.v("Ley", ley.apartado)
            }
        })
        return view
    }
}

