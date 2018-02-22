package com.lovoo.android.data.model.show

import com.squareup.moshi.Json

data class Schedule(

	@Json(name="days")
	val days: List<Any?>? = null,

	@Json(name="time")
	val time: String? = null
)