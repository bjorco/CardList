package com.bjornolsen.cards.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.bjornolsen.cards.data.Card

@Dao
interface CardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(card: Card)

    @Update
    fun update(card: Card)

    @Delete
    fun delete(card: Card)

    @Query("SELECT * FROM card WHERE number == :number")
    fun getCardByNumber(number: Int): LiveData<Card>

    //TODO: Use LiveData
    @Query("SELECT * FROM card")
    fun getAllCards(): List<Card>

    /*
    @Query("SELECT * FROM card")
    fun getAllCards(): LiveData<List<Card>>
    */
}