package com.bjornolsen.cards.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Card(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String,
    var number: Int
)