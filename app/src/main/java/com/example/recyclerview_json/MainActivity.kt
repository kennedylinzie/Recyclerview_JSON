package com.example.recyclerview_json

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.example.recyclerview_json.model.Data
import com.example.recyclerview_json.model.Reqres



class MainActivity : AppCompatActivity() {

    private val datalist: MutableList<Data> = mutableListOf()
    private lateinit var myAdapter: MyAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var recycler = findViewById<RecyclerView>(R.id.my_recycler_view)

        //setup adapter
        myAdapter = MyAdapter(datalist)


        //setup recycler view
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.addItemDecoration(DividerItemDecoration(this,OrientationHelper.VERTICAL))
        recycler.adapter = myAdapter


        //setup android network
        AndroidNetworking.initialize(this);

        AndroidNetworking.get("https://reqres.in/api/users?page=2")
            .build()
            .getAsObject(Reqres::class.java,object : ParsedRequestListener<Reqres>{
                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(p0: Reqres?) {
                    if (p0 != null) {
                        datalist.addAll(p0.data)
                    }
                    myAdapter.notifyDataSetChanged()
                }

                override fun onError(p0: ANError?) {
                    TODO("Not yet implemented")
                }
            })




    }
}