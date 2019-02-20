package com.bjornolsen.cards.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

@Dao
interface StoreDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(store: Store)

    @Update
    fun update(store: Store)

    @Delete
    fun delete(store: Store)

    //TODO: Use LiveData
    @Query("SELECT * FROM store")
    fun getAllStores(): List<Store>
}