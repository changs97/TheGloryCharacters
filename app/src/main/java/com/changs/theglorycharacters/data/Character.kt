package com.changs.theglorycharacters.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Character(
    val actor: String,
    val characterName: String,
    val description: String,
    val id: Int,
    val image: String
) : Parcelable