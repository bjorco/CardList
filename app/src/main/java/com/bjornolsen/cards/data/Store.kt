package com.bjornolsen.cards.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Store (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val image: String
)