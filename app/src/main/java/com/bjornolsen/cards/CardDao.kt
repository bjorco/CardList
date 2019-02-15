package com.bjornolsen.cards

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

@Dao
interface CardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(card: Card)

    @Update
    fun update(card: Card)

    @Delete
    fun delete(card: Card)

    @Query("SELECT * FROM card WHERE number == :number")
    fun getTreesByNumber(number: Int): LiveData<Card>

    //TODO: Use LiveData
    @Query("SELECT * FROM card")
    fun getAllCards(): List<Card>

    /*
    @Query("SELECT * FROM card")
    fun getAllCards(): LiveData<List<Card>>
    */
}