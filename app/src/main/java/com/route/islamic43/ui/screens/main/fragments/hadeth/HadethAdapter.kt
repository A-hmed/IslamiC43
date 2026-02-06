package com.route.islamic43.ui.screens.main.fragments.hadeth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic43.R
import com.route.islamic43.ui.model.HadethDM

class HadethAdapter(val ahadeth: MutableList<HadethDM>, val onClick: (HadethDM) -> Unit) :
    RecyclerView.Adapter<HadethAdapter.HadethViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HadethViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hadeth, parent, false)
        return HadethViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: HadethViewHolder,
        position: Int
    ) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = ahadeth.size


    inner class HadethViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val hadethTitle: TextView = itemView.findViewById(R.id.hadethTitle)
        val hadethContent: TextView = itemView.findViewById(R.id.hadethContent)

        fun bind(position: Int) {
            val hadeth = ahadeth[position]
            hadethTitle.text = hadeth.title
            hadethContent.text = hadeth.content
            itemView.setOnClickListener {
                onClick(hadeth)
            }
        }
    }
}