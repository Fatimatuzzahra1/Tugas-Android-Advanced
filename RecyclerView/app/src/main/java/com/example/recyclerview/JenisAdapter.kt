package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JenisAdapter(var mList : List<JenisData>) :

    RecyclerView.Adapter<JenisAdapter.JenisViewHolder>(){

    inner class JenisViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val fotoTanaman : ImageView = itemView.findViewById(R.id.fotoTanaman)
        val titleTanaman : TextView = itemView.findViewById(R.id.titleTanaman)
    }

    fun setFilteredList(mList: List<JenisData>){
        this.mList = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JenisViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item , parent , false)
        return JenisViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: JenisViewHolder, position: Int) {
        holder.fotoTanaman.setImageResource(mList[position].fotoTanaman)
        holder.titleTanaman.text = mList[position].titleTanaman
    }

    }
