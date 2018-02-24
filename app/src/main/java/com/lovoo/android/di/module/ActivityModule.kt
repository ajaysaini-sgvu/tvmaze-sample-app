package com.lovoo.android.di.module

import com.lovoo.android.ui.episode.EpisodeMvpPresenter
import com.lovoo.android.ui.episode.EpisodePresenter
import com.lovoo.android.ui.episode.EpisodesMvpView
import com.lovoo.android.ui.show.ShowMvpPresenter
import com.lovoo.android.ui.show.ShowMvpView
import com.lovoo.android.ui.show.ShowPresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule {
    @Provides
    fun provideEpisodePresenter(presenter: EpisodePresenter<EpisodesMvpView>): EpisodeMvpPresenter<EpisodesMvpView> = presenter

    @Provides
    fun provideShowPresenter(presenter: ShowPresenter<ShowMvpView>): ShowMvpPresenter<ShowMvpView> = presenter
}