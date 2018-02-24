package com.lovoo.android.data.model.show

import com.squareup.moshi.Json

data class Links(

        @Json(name = "nextepisode")
        val nextepisode: Nextepisode? = null,

        @Json(name = "self")
        val self: Self? = null,

        @Json(name = "previousepisode")
        val previousepisode: Previousepisode? = null
)