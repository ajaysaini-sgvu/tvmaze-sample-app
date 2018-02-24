package com.lovoo.android.ui.show

import com.lovoo.android.data.model.show.ShowResponse
import com.lovoo.android.ui.base.MvpView

interface ShowMvpView: MvpView {

    /**
     * Calls when application receives a show details.
     */
    fun onShowResult(showResponse: ShowResponse)
}