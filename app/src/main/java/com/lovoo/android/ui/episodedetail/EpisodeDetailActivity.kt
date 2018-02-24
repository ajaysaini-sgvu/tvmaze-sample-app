package com.lovoo.android.ui.episodedetail

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.text.Spanned
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.lovoo.android.R
import com.lovoo.android.data.model.episode.EpisodeResponse
import kotlinx.android.synthetic.main.activity_episode_detail.*

/**
 * This activity displays the episode details.
 */
class EpisodeDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_episode_detail)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val episode = intent.getBundleExtra("myBundle").getParcelable<EpisodeResponse>("episode") as EpisodeResponse

        // set the title of the toolbar
        toolbar.title = episode.name

        // download the episode image and set in onto imageview
        Glide.with(this).load(episode.image?.original).
                apply(RequestOptions().error(R.drawable.no_img_landscape_text))
                .into(episode_image)

        // set the summary of episode on textview
        summary_text.text = if(episode.summary.isNullOrBlank()) getString(R.string.episode_detail_no_summary) else episode.summary?.toSpanned()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun String.toSpanned(): Spanned {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY)
        } else {
            @Suppress("DEPRECATION")
            return Html.fromHtml(this)
        }
    }
}