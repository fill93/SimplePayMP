package com.df.simplepaympmodule.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FillMPData(
    @Json(name = "id")                  val id : String? = ""
) : Parcelable