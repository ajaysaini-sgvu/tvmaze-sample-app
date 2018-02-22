package com.lovoo.android.ui.episodes

import com.lovoo.android.data.DataManager
import com.lovoo.android.ui.base.BasePresenter
import com.lovoo.android.utils.rx.SchedulerProvider
import javax.inject.Inject

class EpisodesPresenter<V : EpisodesMvpView> @Inject constructor(private val dm: DataManager, val scheduler: SchedulerProvider) : BasePresenter<V>(dm, scheduler), EpisodesMvpPresenter<V>