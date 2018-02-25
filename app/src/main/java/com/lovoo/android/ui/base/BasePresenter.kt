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

package com.lovoo.android.ui.base

import com.lovoo.android.data.DataManager
import com.lovoo.android.utils.rx.SchedulerProvider

open class BasePresenter<V : MvpView> constructor(private val dm: DataManager, scheduler: SchedulerProvider) : MvpPresenter<V> {

    private var mMvpView: V? = null

    fun getDataManager(): DataManager? = dm

    override fun onDetach() {
        mMvpView = null
    }

    override fun onAttach(mvpView: V) {
        mMvpView = mvpView
    }

    fun getMvpView(): V? = mMvpView

    override fun handleApiError(error: Any) {
        mMvpView?.onError(error as String)
    }

}


