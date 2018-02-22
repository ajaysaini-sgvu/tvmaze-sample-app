package com.lovoo.android

import android.app.Activity
import android.app.Application
import com.lovoo.android.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class LovoolApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var mAndroidDispatchingInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = mAndroidDispatchingInjector

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this)
    }
}