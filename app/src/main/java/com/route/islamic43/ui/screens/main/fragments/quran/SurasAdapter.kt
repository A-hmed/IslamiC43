package com.route.islamic43.ui.screens.main.fragments.quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic43.R
import com.route.islamic43.ui.model.SuraDM

class SurasAdapter(val suras: List<SuraDM>, val onClick: (SuraDM) -> Unit) :
    RecyclerView.Adapter<SurasAdapter.SuraViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): SuraViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sura, parent, false)
        return SuraViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: SuraViewHolder, position: Int
    ) {
        val sura = suras[position]
        holder.suraNumber.text = "${sura.index}"
        holder.suraNameEn.text = sura.nameEn
        holder.suraNameAr.text = sura.nameAr
        holder.suraVerses.text = "${sura.versesCount} Verses"
        holder.itemView.setOnClickListener {
            onClick(sura)
        }
    }

    override fun getItemCount(): Int = suras.size


    class SuraViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val suraNumber: TextView = view.findViewById(R.id.suraNumber)
        val suraNameAr: TextView = view.findViewById(R.id.suraNameAr)
        val suraNameEn: TextView = view.findViewById(R.id.suraNameEn)
        val suraVerses: TextView = view.findViewById(R.id.suraVerses)
    }
}