package com.lovoo.android.activity

import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import com.lovoo.android.BuildConfig
import com.lovoo.android.LovooApplication
import com.lovoo.android.R
import com.lovoo.android.ui.episode.EpisodeActivity
import org.hamcrest.MatcherAssert
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.notNullValue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(application = LovooApplication::class, constants = BuildConfig::class)
class EpisodeActivityTest {

    private lateinit var episodeActivity: EpisodeActivity

    private lateinit var progressBar: ProgressBar

    private lateinit var toolbar: Toolbar

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        episodeActivity = Robolectric.buildActivity(EpisodeActivity::class.java).create().get()
        findViews()
    }

    private fun findViews() {
        progressBar = episodeActivity.findViewById(R.id.progress_bar)
        toolbar = episodeActivity.findViewById(R.id.toolbar)
    }

    @Test
    fun toolbarShouldBePresentAndVisible() {
        assertThat(toolbar, `is`(notNullValue()))
        assertThat(toolbar.visibility, `is`(View.VISIBLE))
    }

    @Test
    fun toolbarShouldHaveProperTitle() {
        val toolbar = episodeActivity.findViewById<TextView>(R.id.toolbar) as Toolbar
        assertThat(toolbar.title.toString(), `is`(episodeActivity.getString(R.string.toolbar_episode_screen_title)))
    }

    @Test
    fun progressBarShouldBeVisible() {
        MatcherAssert.assertThat(progressBar.visibility, Matchers.`is`(View.VISIBLE))
    }
}