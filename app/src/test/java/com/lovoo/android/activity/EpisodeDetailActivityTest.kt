package com.lovoo.android.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import com.lovoo.android.BuildConfig
import com.lovoo.android.LovooApplication
import com.lovoo.android.R
import com.lovoo.android.data.model.episode.EpisodeResponse
import com.lovoo.android.ui.episodedetail.EpisodeDetailActivity
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(application = LovooApplication::class, constants = BuildConfig::class)
class EpisodeDetailActivityTest {

    private lateinit var episodeDetailActivity: EpisodeDetailActivity
    private lateinit var toolbar: Toolbar

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        val intent = Intent()
        val bundle = Bundle()
        bundle.putParcelable("episode", mock(EpisodeResponse::class.java))
        intent.putExtra("myBundle", bundle)

        episodeDetailActivity = Robolectric.buildActivity(EpisodeDetailActivity::class.java, intent).create().get()
        findViews()
    }

    private fun findViews() {
        toolbar = episodeDetailActivity.findViewById(R.id.toolbar)
    }

    @Test
    fun toolbarShouldBePresentAndVisible() {
        MatcherAssert.assertThat(toolbar, Matchers.`is`(Matchers.notNullValue()))
        MatcherAssert.assertThat(toolbar.visibility, Matchers.`is`(View.VISIBLE))
    }
}