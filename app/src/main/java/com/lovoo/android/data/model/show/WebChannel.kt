package com.lovoo.android.data.model.show

import com.squareup.moshi.Json

data class WebChannel(

	@Json(name="country")
	val country: Country? = null,

	@Json(name="name")
	val name: String? = null,

	@Json(name="id")
	val id: Int? = null
)