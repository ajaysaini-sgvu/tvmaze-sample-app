package com.lovoo.android.ui.show

import android.os.Bundle
import com.lovoo.android.R
import com.lovoo.android.data.model.show.ShowResponse
import com.lovoo.android.ui.base.BaseActivity
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

        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        mShowMvpPresenter.onAttach(this)

        // fetch the show detail
        mShowMvpPresenter.loadShow(30634)
    }

    override fun onShowResult(showResponse: ShowResponse) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
