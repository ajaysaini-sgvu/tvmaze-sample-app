package com.lovoo.android.data.model.show

import com.squareup.moshi.Json

data class Rating(

        @Json(name = "average")
        val average: String? = null
)