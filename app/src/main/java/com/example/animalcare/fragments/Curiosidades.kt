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
import com.example.animalcare.adapter.CurAdapter
import com.example.animalcare.viewModels.ViewModelRoom


private lateinit var recyclerView_: RecyclerView
class Curiosidades : Fragment() {

    lateinit var viewModel: ViewModelRoom
    lateinit var curAdapter: CurAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_curiosidades, container, false)
        recyclerView_ = view.findViewById(R.id.rv_curiosidades)
        curAdapter = CurAdapter(emptyList())

        recyclerView_.apply {
            layoutManager = LinearLayoutManager(this@Curiosidades.context)
            adapter = curAdapter
        }


        viewModel = ViewModelProviders.of(this).get(ViewModelRoom::class.java)
        viewModel.getAllCur()
        viewModel.listaCurs.observe(this, Observer { listaCurs ->
            curAdapter.updateList(listaCurs)
            for (cur in listaCurs) {
            }
        })
        return view
    }
}

