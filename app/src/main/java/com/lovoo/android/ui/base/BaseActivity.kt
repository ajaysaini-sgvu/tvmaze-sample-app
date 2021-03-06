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

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.lovoo.android.R
import com.lovoo.android.utils.NetworkUtils
import dagger.android.AndroidInjection

abstract class BaseActivity : AppCompatActivity(), MvpView {

    private var mProgressBar: ProgressBar? = null

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        performDependencyInjection()
        super.onCreate(savedInstanceState)
    }

    override val isNetworkConnected: Boolean
        get() = NetworkUtils.isNetworkConnected(this)

    override fun showLoading() {
        hideLoading()
        mProgressBar = findViewById<ProgressBar>(R.id.progress_bar)
        mProgressBar?.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        mProgressBar?.visibility = View.INVISIBLE
    }

    override fun onError(message: String?) {
        if (message != null) {
            showSnackBar(message)
        } else {
            showSnackBar(getString(R.string.something_went_wrong))
        }
    }

    override fun onError(@StringRes resId: Int) {
        onError(getString(resId))
    }

    override fun showMessage(message: String?) {
        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show()
        }
    }

    override fun showMessage(@StringRes resId: Int) {
        showMessage(getString(resId))
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun requestPermissionsSafely(permissions: Array<String>, requestCode: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode)
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun hasPermission(permission: String): Boolean = Build.VERSION.SDK_INT < Build.VERSION_CODES.M || checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED

    private fun showSnackBar(message: String) {
        val snackbar = Snackbar.make(findViewById<View>(android.R.id.content), message, Snackbar.LENGTH_SHORT)
        val textView = snackbar.view.findViewById<TextView>(android.support.design.R.id.snackbar_text) as TextView
        textView.setTextColor(ContextCompat.getColor(this, android.R.color.white))
        snackbar.show()
    }

    @SuppressLint("CheckResult")
    private fun performDependencyInjection() {
        AndroidInjection.inject(this)
    }
}