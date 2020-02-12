package com.sample.common.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.sample.common.extension.setupSnackbar

abstract class BaseFragment: Fragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupSnackbar(this, getViewModel().errorHandler, Snackbar.LENGTH_LONG)
    }

    abstract fun getViewModel(): BaseViewModel
}