/*
 * Copyright 2018 Ajay Saini
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package com.lovoo.android.data.model.show

import com.lovoo.android.data.remote.BaseResponse
import com.squareup.moshi.Json

data class ShowResponse(

        @Json(name = "summary")
        val summary: String? = null,

        @Json(name = "image")
        val image: Image? = null,

        @Json(name = "_links")
        val links: Links? = null,

        @Json(name = "premiered")
        val premiered: String? = null,

        @Json(name = "rating")
        val rating: Rating? = null,

        @Json(name = "runtime")
        val runtime: Int? = null,

        @Json(name = "weight")
        val weight: Int? = null,

        @Json(name = "language")
        val language: String? = null,

        @Json(name = "type")
        val type: String? = null,

        @Json(name = "url")
        val url: String? = null,

        @Json(name = "officialSite")
        val officialSite: String? = null,

        @Json(name = "network")
        val network: Any? = null,

        @Json(name = "schedule")
        val schedule: Schedule? = null,

        @Json(name = "webChannel")
        val webChannel: WebChannel? = null,

        @Json(name = "genres")
        val genres: List<String?>? = null,

        @Json(name = "name")
        val name: String? = null,

        @Json(name = "id")
        val id: Int? = null,

        @Json(name = "externals")
        val externals: Externals? = null,

        @Json(name = "updated")
        val updated: Int? = null,

        @Json(name = "status")
        val status: String? = null
) : BaseResponse()