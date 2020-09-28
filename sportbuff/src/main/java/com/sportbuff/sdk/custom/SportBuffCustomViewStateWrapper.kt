package com.sportbuff.sdk.custom

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class SportBuffCustomViewStateWrapper(
        val superState: Parcelable?,
        val state: SportBuffCustomViewState?
): Parcelable