package com.sportbuff.sdk.ui.sportbuff

import com.sportbuff.sdk.entities.BuffsEntity
import com.sportbuff.sdk.custom.SportBuffCustomViewState
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CustomViewState(val hexCode: BuffsEntity?): SportBuffCustomViewState