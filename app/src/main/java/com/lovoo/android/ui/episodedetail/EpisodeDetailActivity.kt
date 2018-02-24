package com.lovoo.android.ui.episodedetail

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.Spanned
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.lovoo.android.R
import com.lovoo.android.data.model.episode.EpisodeResponse
import com.lovoo.android.ui.base.BaseActivity
import com.lovoo.android.ui.show.ShowActivity
import kotlinx.android.synthetic.main.activity_episode_detail.*

/**
 * This activity displays the episode details.
 */
class EpisodeDetailActivity : BaseActivity() {

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

        // click listener on show detail button
        // it opens an activity which displays show detail
        show_detail_button.setOnClickListener {
            val intent = Intent(this@EpisodeDetailActivity, ShowActivity::class.java)
            startActivity(intent)
        }
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

    /**
     * Returns displayable styled text from the provided HTML string.
     * Any <img> tags in the HTML will display as a generic replacement image which your program can then go through
     * and replace with real images.
     */
    private fun String.toSpanned(): Spanned {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY)
        } else {
            @Suppress("DEPRECATION")
            return Html.fromHtml(this)
        }
    }
}