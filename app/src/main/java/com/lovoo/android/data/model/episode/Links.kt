package com.lovoo.android.data.model.episode

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Links(

        @Json(name = "self")
        val self: Self? = null
) : Parcelable