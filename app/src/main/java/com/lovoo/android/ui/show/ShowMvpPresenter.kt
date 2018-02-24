package com.lovoo.android.ui.show

import com.lovoo.android.ui.base.MvpPresenter

interface ShowMvpPresenter<V : ShowMvpView> : MvpPresenter<V> {
    fun loadShow(id: Int)
}
