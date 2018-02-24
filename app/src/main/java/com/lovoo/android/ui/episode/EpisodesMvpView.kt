package com.lovoo.android.ui.episode

import com.lovoo.android.data.model.episode.EpisodeResponse
import com.lovoo.android.ui.base.MvpView

interface EpisodesMvpView : MvpView {

    /**
     * Calls when application receives a list of episodes.
     */
    fun onEpisodeResult(episodes: List<EpisodeResponse>)
}