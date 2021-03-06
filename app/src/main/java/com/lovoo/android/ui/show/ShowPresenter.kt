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

import com.lovoo.android.data.DataManager
import com.lovoo.android.data.model.show.ShowResponse
import com.lovoo.android.data.remote.CallbackWrapper
import com.lovoo.android.ui.base.BasePresenter
import com.lovoo.android.utils.rx.SchedulerProvider
import javax.inject.Inject

class ShowPresenter<V : ShowMvpView> @Inject constructor(private val dm: DataManager, private val scheduler: SchedulerProvider) : BasePresenter<V>(dm, scheduler), ShowMvpPresenter<V> {

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun loadShow(id: Int) {
        // display progress bar
        getMvpView()!!.showLoading()

        getDataManager()!!.getShowDetail(id)!!.subscribeOn(scheduler.io()).observeOn(scheduler.ui())
                .subscribeWith(object : CallbackWrapper<ShowResponse>() {

                    override fun onSuccess(showResponse: ShowResponse) {
                        // dismiss the progress bar
                        getMvpView()!!.hideLoading()

                        // send back result to activity
                        getMvpView()!!.onShowResult(showResponse)
                    }

                    override fun onError(error: Any) {
                        // dismiss the progress bar
                        getMvpView()!!.hideLoading()

                        // error handling
                        handleApiError(error)
                    }
                })
    }
}
