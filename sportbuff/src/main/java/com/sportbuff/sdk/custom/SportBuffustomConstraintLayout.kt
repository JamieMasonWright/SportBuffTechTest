package com.sportbuff.sdk.custom

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.LifecycleOwner
import com.sportbuff.sdk.error.LifecycleOwnerNotFoundException

abstract class SportBuffustomConstraintLayout<V: SportBuffCustomViewState, T: SportBuffCustomViewModel<V>>(
        context: Context,
        attributeSet: AttributeSet
): ConstraintLayout(context, attributeSet), SportBuffCustomView<V, T> {
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        val lifecycleOwner = context as? LifecycleOwner ?: throw LifecycleOwnerNotFoundException()
        onLifecycleOwnerAttached(lifecycleOwner)
    }

    override fun onSaveInstanceState() = SportBuffCustomViewStateWrapper(
        super.onSaveInstanceState(), viewModel.state)

    @Suppress("UNCHECKED_CAST")
    override fun onRestoreInstanceState(state: Parcelable?) {
        if (state is SportBuffCustomViewStateWrapper) {
            viewModel.state = state.state as V?
            super.onRestoreInstanceState(state.superState)
        }
    }
}