package com.lovoo.android.data.model.show

import com.lovoo.android.data.remote.BaseResponse
import com.squareup.moshi.Json

data class ShowResponse(

	@Json(name="summary")
	val summary: String? = null,

	@Json(name="image")
	val image: Image? = null,

	@Json(name="_links")
	val links: Links? = null,

	@Json(name="premiered")
	val premiered: String? = null,

	@Json(name="rating")
	val rating: Rating? = null,

	@Json(name="runtime")
	val runtime: Int? = null,

	@Json(name="weight")
	val weight: Int? = null,

	@Json(name="language")
	val language: String? = null,

	@Json(name="type")
	val type: String? = null,

	@Json(name="url")
	val url: String? = null,

	@Json(name="officialSite")
	val officialSite: String? = null,

	@Json(name="network")
	val network: Any? = null,

	@Json(name="schedule")
	val schedule: Schedule? = null,

	@Json(name="webChannel")
	val webChannel: WebChannel? = null,

	@Json(name="genres")
	val genres: List<String?>? = null,

	@Json(name="name")
	val name: String? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="externals")
	val externals: Externals? = null,

	@Json(name="updated")
	val updated: Int? = null,

	@Json(name="status")
	val status: String? = null
): BaseResponse()