package com.lovoo.android.data.model.show

import com.squareup.moshi.Json

data class Country(

	@Json(name="code")
	val code: String? = null,

	@Json(name="timezone")
	val timezone: String? = null,

	@Json(name="name")
	val name: String? = null
)