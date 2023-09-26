package com.example.challenge2_binar.produk

import com.example.challenge2_binar.R

object Kategori {
    val kategori : List<Any>
        get() = mutableListOf(
            KategoriMenu(R.drawable.nasitahu, "Nasi"),
            KategoriMenu(R.drawable.spaghetti, "Mie"),
            KategoriMenu(R.drawable.cinamonroll, "Snack"),
            KategoriMenu(R.drawable.eskopi, "Minuman"),
        )
}