package com.lovoo.android.data.model.episode

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Image(

        @Json(name = "original")
        val original: String? = null,

        @Json(name = "medium")
        val medium: String? = null
) : Parcelable