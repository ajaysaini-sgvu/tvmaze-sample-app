package com.lovoo.android.ui.episodes

import android.os.Bundle
import com.lovoo.android.R
import com.lovoo.android.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_episodes.*

class EpisodesActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_episodes)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        // set the title of the toolbar
        toolbar.title = getString(R.string.toolbar_episode_screen_title)
    }
}
