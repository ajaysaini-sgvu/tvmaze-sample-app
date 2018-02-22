package com.lovoo.android.ui.episode

import android.os.Bundle
import com.lovoo.android.R
import com.lovoo.android.data.model.episode.EpisodeResponse
import com.lovoo.android.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_episodes.*
import javax.inject.Inject

class EpisodeActivity : BaseActivity(), EpisodesMvpView {

    @Inject
    lateinit var mEpisodeMvpPresenter: EpisodeMvpPresenter<EpisodesMvpView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_episodes)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        // set the title of the toolbar
        toolbar.title = getString(R.string.toolbar_episode_screen_title)

        mEpisodeMvpPresenter.onAttach(this)

        mEpisodeMvpPresenter.loadEpisode(30634)
    }

    override fun onEpisodeResult(episodeResponse: List<EpisodeResponse>) {

    }

}
