package com.example.challenge2_binar.produk

import android.os.Parcelable
import android.view.Menu
import kotlinx.parcelize.Parcelize

@Parcelize
data class MenuList(
    var imgMenu: Int,
    var namaMenu: String,
    var hargaMenu: String,
    var description: String,
    var namaToko: String,
    var location: String,
    val maps: String
):Parcelable