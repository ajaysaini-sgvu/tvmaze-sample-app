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

package com.lovoo.android.di.component

import com.lovoo.android.LovooApplication
import com.lovoo.android.di.builder.ActivityBuilder
import com.lovoo.android.di.module.ActivityModule
import com.lovoo.android.di.module.HelpersModule
import com.lovoo.android.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(modules = arrayOf(AndroidSupportInjectionModule::class, HelpersModule::class, NetworkModule::class,
        ActivityBuilder::class, ActivityModule::class))
@Singleton
interface AppComponent {

    fun inject(app: LovooApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: LovooApplication): Builder

        fun build(): AppComponent
    }
}