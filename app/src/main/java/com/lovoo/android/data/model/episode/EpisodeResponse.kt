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