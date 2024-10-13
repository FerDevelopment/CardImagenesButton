package com.example.cardimagenesbutton.data

import com.example.cardimagenesbutton.R
import com.example.cardimagenesbutton.model.Bandera

class Datos {
    // Bandera(/*Nombre del pais*/,/*Bandera img*/,/*Capital    */)
    fun cargarBanderas(): List<Bandera> = listOf(
        Bandera(R.string.spain, R.drawable.flag_of_spain, R.string.spainCapital),
        Bandera(R.string.austria, R.drawable.flag_of_austria, R.string.austriaCapital),
        Bandera(R.string.denmark, R.drawable.flag_of_denmark, R.string.denmarkCapital),
        Bandera(R.string.belgium, R.drawable.flag_of_belgium, R.string.belgiumCapital),
        Bandera(R.string.germany, R.drawable.flag_of_germany, R.string.germanyCapital),
        Bandera(R.string.netherlands, R.drawable.flag_of_the_netherlands, R.string.netherlandsCapital),
    )
}