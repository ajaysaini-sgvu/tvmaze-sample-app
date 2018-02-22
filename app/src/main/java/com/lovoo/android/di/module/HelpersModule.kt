/*
 * Copyright 2018 Ajay Saini
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lovoo.android.di.module

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.lovoo.android.LovooApplication
import com.lovoo.android.data.AppDataManager
import com.lovoo.android.data.DataManager
import com.lovoo.android.data.pref.AppPreferencesHelper
import com.lovoo.android.data.pref.PreferencesHelper
import com.lovoo.android.data.remote.ApiHelper
import com.lovoo.android.data.remote.ApiHelperImpl
import com.lovoo.android.utils.rx.AppSchedulerProvider
import com.lovoo.android.utils.rx.SchedulerProvider
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class HelpersModule {

    @Provides
    @Singleton
    fun providesSharedPreferences(application: LovooApplication): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(application)

    @Provides
    fun provideContext(app: LovooApplication): Context = app.applicationContext

    @Singleton
    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder().build()

    @Provides
    @Singleton
    fun provideApiHelper(apiHelperImpl: ApiHelperImpl): ApiHelper = apiHelperImpl

    @Provides
    @Singleton
    fun provideDataManager(appDataManager: AppDataManager): DataManager = appDataManager

    @Provides
    @Singleton
    fun providePreferenceManager(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper = appPreferencesHelper


    @Provides
    @Singleton
    fun provideSchedulerProvider(appSchedulerProvider: AppSchedulerProvider): SchedulerProvider = appSchedulerProvider

}