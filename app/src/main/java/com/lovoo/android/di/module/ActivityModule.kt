package com.lovoo.android.di.module

import com.lovoo.android.ui.episode.EpisodeMvpPresenter
import com.lovoo.android.ui.episode.EpisodePresenter
import com.lovoo.android.ui.episode.EpisodesMvpView
import dagger.Module
import dagger.Provides

@Module
class ActivityModule {
    @Provides
    fun provideEpisodePresenter(presenter: EpisodePresenter<EpisodesMvpView>): EpisodeMvpPresenter<EpisodesMvpView> = presenter

}