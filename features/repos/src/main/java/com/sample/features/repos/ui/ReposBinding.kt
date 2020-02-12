package com.sample.features.repos.ui

import android.util.Log
import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.sample.data.model.Repo
import com.sample.data.repository.utils.Resource

object ReposBinding {

    @BindingAdapter("showWhenLoading")
    @JvmStatic
    fun <T>showWhenLoading(view: SwipeRefreshLayout, resource: Resource<T>?) {
        Log.d(ReposBinding::class.java.simpleName, "Resource: $resource")
        if (resource != null) view.isRefreshing = resource.status == Resource.Status.LOADING
    }

    @BindingAdapter("items")
    @JvmStatic fun setItems(recyclerView: RecyclerView, resource: Resource<List<Repo>>?) {
        with(recyclerView.adapter as ReposAdapter) {
            resource?.data?.let { updateData(it) }
        }
    }

    @BindingAdapter("showWhenEmptyList")
    @JvmStatic fun showMessageErrorWhenEmptyList(view: View, resource: Resource<List<Repo>>?) {
        if (resource!=null) {
            view.visibility = if (resource.status == Resource.Status.ERROR
                && resource.data != null
                && resource.data!!.isEmpty()) View.VISIBLE else View.GONE
        }
    }
}