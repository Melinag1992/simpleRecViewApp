package com.example.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.recyclerview.adapters.FeedRecyclerViewAdapter
import com.example.myapplication.models.DataSource
import com.example.myapplication.recyclerview.adapters.TopSpacingItemDecoration
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
  private  lateinit var  feedAdapter: FeedRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        addDataSet()

    }


    private  fun addDataSet(){
        val data = DataSource.createDataSet()
        feedAdapter.submitList(data)
    }
        private fun initRecyclerView(){
            rv_feed.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                val topSpacingItemDecoration = TopSpacingItemDecoration(30)
                addItemDecoration(topSpacingItemDecoration)
                feedAdapter = FeedRecyclerViewAdapter()
                adapter = feedAdapter

        }
    }
}