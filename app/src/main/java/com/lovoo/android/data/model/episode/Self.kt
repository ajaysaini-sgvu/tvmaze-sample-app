package com.lovoo.android.data.model.episode

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Self(

        @Json(name = "href")
        val href: String? = null
) : Parcelable