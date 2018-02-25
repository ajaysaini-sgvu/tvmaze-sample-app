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

package com.lovoo.android.ui.show

import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.view.MenuItem
import com.lovoo.android.R
import com.lovoo.android.data.model.show.ShowResponse
import com.lovoo.android.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_show.*
import javax.inject.Inject

/**
 * This activity is to display show detail.
 */
class ShowActivity : BaseActivity(), ShowMvpView {

    @Inject
    lateinit var mShowMvpPresenter: ShowMvpPresenter<ShowMvpView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        ViewCompat.setTranslationZ(progress_bar,
                2 * this.resources.displayMetrics.density // dp to pixel
        )

        mShowMvpPresenter.onAttach(this)

        // fetch the show detail
        mShowMvpPresenter.loadShow(30634)
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

    override fun onShowResult(showResponse: ShowResponse) {

    }

}
