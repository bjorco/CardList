package com.bjornolsen.cards.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Card(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val number: Int,
    val image: Int
)