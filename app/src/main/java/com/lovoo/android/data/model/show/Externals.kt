package com.lovoo.android.data.model.show

import com.squareup.moshi.Json

data class Externals(

	@Json(name="thetvdb")
	val thetvdb: Int? = null,

	@Json(name="imdb")
	val imdb: String? = null,

	@Json(name="tvrage")
	val tvrage: Any? = null
)