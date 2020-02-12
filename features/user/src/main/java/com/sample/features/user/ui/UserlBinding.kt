package com.sample.features.user.ui

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sample.data.repository.utils.Resource

object UserlBinding {

    @BindingAdapter("imageUrlRounded")
    @JvmStatic fun loadImageRounded(view: ImageView, url: String?) {
        Glide.with(view.context).load(url).apply(RequestOptions.circleCropTransform()).into(view)
    }

    @BindingAdapter("showWhenLoading")
    @JvmStatic
    fun showWhenLoading(view: SwipeRefreshLayout, status: Resource.Status?) {
        Log.d(UserlBinding::class.java.simpleName, "Status: $status")
        status?.let {
            view.isRefreshing = it == Resource.Status.LOADING
        }
    }
}