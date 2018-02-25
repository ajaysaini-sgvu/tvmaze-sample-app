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