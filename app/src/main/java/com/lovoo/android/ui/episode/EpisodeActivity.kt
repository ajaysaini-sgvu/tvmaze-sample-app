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

package com.lovoo.android.ui.episode

import android.content.Intent
import android.os.Bundle
import com.lovoo.android.R
import com.lovoo.android.data.model.episode.EpisodeResponse
import com.lovoo.android.ui.base.BaseActivity
import com.lovoo.android.ui.episodedetail.EpisodeDetailActivity
import kotlinx.android.synthetic.main.activity_episodes.*
import javax.inject.Inject

/**
 * This activity displays the list of episodes of a specific show id.
 */
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

        // load the episodes of show
        mEpisodeMvpPresenter.loadEpisode(resources.getInteger(R.integer.show_id))
    }

    override fun onEpisodeResult(episodes: List<EpisodeResponse>) {
        recycler_view_episodes.adapter = EpisodeAdapter(episodes, object : EpisodeAdapter.OnItemClickListener {
            override fun onClick(episode: EpisodeResponse) {
                val intent = Intent(this@EpisodeActivity, EpisodeDetailActivity::class.java)
                val bundle = Bundle()
                bundle.putParcelable("episode", episode)
                intent.putExtra("myBundle", bundle)
                startActivity(intent)

            }
        })
    }

}
