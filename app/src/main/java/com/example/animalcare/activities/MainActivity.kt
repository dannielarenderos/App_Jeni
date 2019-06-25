package com.example.animalcare.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animalcare.R
import com.example.animalcare.adapter.LeyAdapter
import com.example.animalcare.viewModels.ViewModelRoom
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_laws.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: ViewModelRoom
    lateinit var leyAdapter: LeyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
/*
        leyAdapter = LeyAdapter(emptyList())

        rv_leyesMainAct.apply{
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = leyAdapter
        }

        viewModel = ViewModelProviders.of(this).get(ViewModelRoom::class.java)
        viewModel.getAllLeyes()
        viewModel.listaLeyes.observe(this, Observer {listaDeLeyes->
            leyAdapter.updateList(listaDeLeyes)
           for (ley in listaDeLeyes){

               Log.v("Ley", ley.apartado)
           }
        })
        */
    }
}
