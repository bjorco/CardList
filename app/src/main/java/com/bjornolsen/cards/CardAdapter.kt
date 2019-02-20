package com.bjornolsen.cards

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bjornolsen.cards.data.Card

class CardAdapter(context: Context, private val mCards: ArrayList<Card>) : RecyclerView.Adapter<CardAdapter.ViewHolder>() {
    class ViewHolder(v : View) : RecyclerView.ViewHolder(v) {
        val mCardName : TextView = v.findViewById(R.id.cr_txt_card_name)
        val mCardNumber : TextView = v.findViewById(R.id.cr_txt_card_number)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mCards.size
    }

    override fun onBindViewHolder(holder: CardAdapter.ViewHolder, position: Int) {
        holder.mCardName.text = mCards[position].name
        holder.mCardNumber.text = mCards[position].number.toString()
    }


}