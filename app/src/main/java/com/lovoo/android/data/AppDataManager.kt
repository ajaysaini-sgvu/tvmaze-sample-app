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

package com.lovoo.android.data

import android.content.Context
import com.lovoo.android.data.model.episode.EpisodeResponse
import com.lovoo.android.data.model.show.ShowResponse
import com.lovoo.android.data.pref.PreferencesHelper
import com.lovoo.android.data.remote.ApiHelper
import io.reactivex.Observable
import javax.inject.Inject

open class AppDataManager @Inject constructor(private val preferencesHelper: PreferencesHelper,
                                              private val apiHelper: ApiHelper,
                                              private val context: Context) : DataManager {

    override fun getEpisodeList(id: Int): Observable<List<EpisodeResponse>>? = apiHelper.getEpisodeList(id)
    override fun getShowDetail(id: Int): Observable<ShowResponse>? = apiHelper.getShowDetail(id)

}