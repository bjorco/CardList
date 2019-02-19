package com.bjornolsen.cards

import android.arch.persistence.room.Room
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.bjornolsen.cards.data.Card
import com.bjornolsen.cards.data.Database
import kotlinx.android.synthetic.main.activity_create_cards.*
import kotlinx.android.synthetic.main.content_create_cards.*

class CreateCardsActivity : AppCompatActivity() {

    private val TAG = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_cards)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            insertCard(cc_edt_card_name.text.toString(),cc_edt_card_number.text.toString().toInt())
        }
    }

    //TODO: Move to viewmodel
    private fun insertCard(name : String, number : Int){
        Log.d(TAG, "insertCard: name:$name & number:$number")
        //TODO: Add dependency injection and use a background thread
        val db = Room.databaseBuilder(applicationContext, Database::class.java, "cardsDatabase")
            .allowMainThreadQueries()
            .build()

        db.cardDao().insert(Card(0, name, number))

        finish()
    }
}
