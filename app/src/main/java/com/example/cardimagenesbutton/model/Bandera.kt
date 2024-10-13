package com.example.cardimagenesbutton.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Bandera(
    @StringRes val stringResourceIdName: Int,
    @DrawableRes val imagenResourceId: Int,
    @StringRes val stringResourceIdDescription: Int
    )
