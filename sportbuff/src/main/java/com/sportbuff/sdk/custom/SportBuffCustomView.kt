package com.sportbuff.sdk.custom

import androidx.lifecycle.LifecycleOwner

interface SportBuffCustomView<V: SportBuffCustomViewState, T: SportBuffCustomViewModel<V>> {
    val viewModel: T

    fun onLifecycleOwnerAttached(lifecycleOwner: LifecycleOwner)
}