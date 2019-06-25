package com.example.animalcare.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animalcare.R
import com.example.animalcare.adapter.OrgAdapter
import com.example.animalcare.viewModels.ViewModelRoom

private lateinit var recyclerViewOrg: RecyclerView

class Fragmento_Organizacion : Fragment() {


    private lateinit var OrgViewModel: ViewModelRoom
    private lateinit var OrgAdapter: OrgAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_fragmento__organizacion, container, false)
        recyclerViewOrg = view.findViewById(R.id.rv_organizaciones)
        OrgAdapter = OrgAdapter(emptyList())


        recyclerViewOrg.apply {
            layoutManager = GridLayoutManager(this@Fragmento_Organizacion.context, 2)
            adapter = OrgAdapter
        }


        OrgViewModel = ViewModelProviders.of(this).get(ViewModelRoom::class.java)
        OrgViewModel.getAllLOrgs()
        OrgViewModel.listaOrgs.observe(this, Observer { listaDeOrgs ->
            OrgAdapter.updateList(listaDeOrgs)
            for (org in listaDeOrgs) {

            }
        })
        return view


    }
}
