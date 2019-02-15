package com.bjornolsen.cards

import android.arch.persistence.room.Room
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
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

    private fun populateRecyclerView(){
        //TODO: Add dependency injection and use a background thread
        val db = Room.databaseBuilder(applicationContext, Database::class.java, "cardsDatabase")
            .allowMainThreadQueries()
            .build()

        val cards = ArrayList<Card>(db.cardDao().getAllCards())

        Log.d(TAG, "populateRecyclerView with ${cards.size} items")

        recycler_view.adapter = CardAdapter(this, cards)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.addItemDecoration(DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL))
    }

    override fun onResume() {
        populateRecyclerView()
        super.onResume()
    }
}
