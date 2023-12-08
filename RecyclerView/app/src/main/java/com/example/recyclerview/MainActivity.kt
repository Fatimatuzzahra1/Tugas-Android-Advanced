package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.widget.SearchView
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView : SearchView
    private lateinit var mList : ArrayList<JenisData>
    private lateinit var adapter : JenisAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView) as SearchView

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        mList = ArrayList()

        addDataToList()
        adapter = JenisAdapter(mList)
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                filterList(p0)
                return true
            }

        })

    }

    private fun filterList(query : String?){

        if (query != null){
            val filteredList = ArrayList<JenisData>()
            for (i in mList){
                if (i.titleTanaman.lowercase(Locale.ROOT).contains(query)){
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()){
                Toast.makeText(this , "Data Tidak Ditemukan" , Toast.LENGTH_SHORT).show()
            }else{
                adapter.setFilteredList(filteredList)
            }
        }


    }

    private fun addDataToList(){
        mList.add(JenisData("Bunga Geranium", R.drawable.hias1))
        mList.add(JenisData("Bunga Anggrek Bulan", R.drawable.anggrekbulan))
        mList.add(JenisData("Bunga Anggrek", R.drawable.anggrek))
        mList.add(JenisData("Bunga Ballerina Roses", R.drawable.ballerinaroses))
        mList.add(JenisData("Bunga Double Delight Roses", R.drawable.doubledelightroses))
        mList.add(JenisData("Bunga Iceberg Roses", R.drawable.icebergroses))
        mList.add(JenisData("Bunga Monstera", R.drawable.monstera))




    }
}