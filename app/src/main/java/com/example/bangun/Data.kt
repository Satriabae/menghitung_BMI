package com.example.bangun

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Data(
    val nama: String,
    val gender:String,
    val umur: String,
    val hitung: Double,
    val jenis: String
) :Parcelable
