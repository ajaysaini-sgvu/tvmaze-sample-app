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

import com.squareup.moshi.Json

data class Links(

        @Json(name = "nextepisode")
        val nextepisode: Nextepisode? = null,

        @Json(name = "self")
        val self: Self? = null,

        @Json(name = "previousepisode")
        val previousepisode: Previousepisode? = null
)