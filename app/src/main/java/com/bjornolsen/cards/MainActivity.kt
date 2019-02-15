package com.bjornolsen.cards

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener{startActivity(Intent(this, CreateCards::class.java))}

        populateRecyclerView()
    }

    fun populateRecyclerView(){

        val cards = ArrayList<Card>()

        for (i in 1..10){
            val c = Card(0,"Dunder$i",i)
            cards.add(c)
        }


        recycler_view.adapter = CardAdapter(this, cards)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.addItemDecoration(DividerItemDecoration(recycler_view.context, DividerItemDecoration.VERTICAL))
    }
}
