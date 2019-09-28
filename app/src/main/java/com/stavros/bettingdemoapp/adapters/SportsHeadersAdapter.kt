package com.stavros.bettingdemoapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.stavros.bettingdemoapp.R

class SportsHeadersAdapter(val sportsHeafers:ArrayList<String>): RecyclerView.Adapter<SportsHeadersAdapter.ViewHolder>() {

    override fun getItemCount() =  sportsHeafers.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.headerName.text = sportsHeafers[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int ): ViewHolder {
        val view: View =LayoutInflater.from(parent.context).inflate(R.layout.row_pos,parent,false)
        return ViewHolder(view)
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val headerName: TextView = itemView.findViewById(R.id.headerName)
    }
}