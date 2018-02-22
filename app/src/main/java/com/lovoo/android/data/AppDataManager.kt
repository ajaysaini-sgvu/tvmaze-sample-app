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