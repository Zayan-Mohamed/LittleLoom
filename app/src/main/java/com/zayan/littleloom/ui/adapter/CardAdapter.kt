package com.example.littleloom.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zayan.littleloom.R
import com.zayan.littleloom.model.CardItem

class CardAdapter(
    private val items: List<CardItem>,
    private val onItemClick: (CardItem) -> Unit
) : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { onItemClick(item) }
    }

    override fun getItemCount() = items.size

    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ivCardIcon: ImageView = itemView.findViewById(R.id.ivCardIcon)
        private val tvCardTitle: TextView = itemView.findViewById(R.id.tvCardTitle)
        private val tvCardDescription: TextView = itemView.findViewById(R.id.tvCardDescription)

        fun bind(item: CardItem) {
            ivCardIcon.setImageResource(item.iconResId)
            tvCardTitle.text = item.title
            tvCardDescription.text = item.description
        }
    }
}
