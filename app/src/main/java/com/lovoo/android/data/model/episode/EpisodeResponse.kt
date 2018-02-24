package com.lovoo.android.data.model.episode

import android.os.Parcelable
import com.lovoo.android.data.remote.BaseResponse
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EpisodeResponse(

        @Json(name = "summary")
        val summary: String? = null,

        @Json(name = "number")
        val number: Int? = null,

        @Json(name = "airtime")
        val airtime: String? = null,

        @Json(name = "image")
        val image: Image? = null,

        @Json(name = "_links")
        val links: Links? = null,

        @Json(name = "airdate")
        val airdate: String? = null,

        @Json(name = "name")
        val name: String? = null,

        @Json(name = "season")
        val season: Int? = null,

        @Json(name = "runtime")
        val runtime: Int? = null,

        @Json(name = "airstamp")
        val airstamp: String? = null,

        @Json(name = "id")
        val id: Int? = null,

        @Json(name = "url")
        val url: String? = null
) : BaseResponse(), Parcelable