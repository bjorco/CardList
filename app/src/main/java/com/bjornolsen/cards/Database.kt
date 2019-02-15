package com.bjornolsen.cards

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [Card::class], version = 1)
abstract class Database : RoomDatabase(){
    abstract fun cardDao() : CardDao
}