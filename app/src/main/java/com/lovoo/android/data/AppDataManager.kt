package com.lovoo.android.data

import android.content.Context
import com.lovoo.android.data.pref.PreferencesHelper
import com.lovoo.android.data.remote.ApiHelper
import javax.inject.Inject

open class AppDataManager @Inject constructor(private val preferencesHelper: PreferencesHelper,
                                              private val apiHelper: ApiHelper,
                                              private val context: Context) : DataManager