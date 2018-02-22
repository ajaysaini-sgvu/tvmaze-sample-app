package com.lovoo.android.data.model.episode

import com.squareup.moshi.Json

data class Image(

	@Json(name="original")
	val original: String? = null,

	@Json(name="medium")
	val medium: String? = null
)