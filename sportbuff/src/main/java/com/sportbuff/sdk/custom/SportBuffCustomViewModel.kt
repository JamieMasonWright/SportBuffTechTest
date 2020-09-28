package com.sportbuff.sdk.custom

interface SportBuffCustomViewModel<T: SportBuffCustomViewState> {
    var state: T?
}