package com.example.unraveltravels.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.unraveltravels.R
import com.example.unraveltravels.adapter.MainRecyclerListViewAdapter
import com.example.unraveltravels.dataLayer.MainViewModel


class MainActivity : AppCompatActivity() {

    private var mainViewModel: MainViewModel? = null
    private var mainListRecyclerView : RecyclerView ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fullscreen)
        mainListRecyclerView = findViewById(R.id.mainListRecyclerView)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        observeData()
        mainViewModel?.parseResponse()
    }

    private fun observeData() {
        if (mainViewModel != null) {
            mainViewModel!!.getResponseData().observe(this, { responseModel ->
                val list = responseModel.itemList
                val adapter = MainRecyclerListViewAdapter(this, list!!)
                val layoutManager = LinearLayoutManager(this)
                mainListRecyclerView?.layoutManager = layoutManager
                mainListRecyclerView?.adapter = adapter
            })
        }
    }
}