package com.sportbuff.sdk.ui.sportbuff

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sportbuff.sdk.network.SportBuffApi
import com.sportbuff.sdk.entities.BuffsEntity
import com.sportbuff.sdk.custom.SportBuffCustomViewModel
import com.sportbuff.sdk.error.ResultWrapper
import com.sportbuff.sdk.network.RetrofitApi
import com.sportbuff.sdk.network.networkBounceResource
import kotlinx.coroutines.*

class SportBuffViewModel: ViewModel(), SportBuffCustomViewModel<CustomViewState> {
    private lateinit var countDownJob: Job
    private val buffsLiveData = MutableLiveData<BuffsEntity?>()
    private val countDownTimerLiveData = MutableLiveData<Int>()

    fun getBuffsLiveData() = buffsLiveData
    fun getCountDownTimerLiveData() = countDownTimerLiveData

    init {
        initBuffUps()
    }

    private fun initBuffUps() {
        viewModelScope.launch {
            delay(10000) // Start buff ups after 10 seconds.
            repeat(5) {
                getBuffs(it + 1)
                delay(30000) // A new buff will be shown every 30 seconds
            }
        }
    }

    private fun getBuffs(buffId: Int) {
        viewModelScope.launch {
            val response = networkBounceResource {
                val buffsApi = RetrofitApi
                    .retrofitInstance?.create(SportBuffApi::class.java)

                buffsApi?.getBuffs(buffId)
            }

            if(response is ResultWrapper.Success)
                buffsLiveData.postValue(response.value)
        }
    }

    override var state: CustomViewState? = null
        get() = CustomViewState(buffsLiveData.value)
        set(value) {
            field = value
            restore(value)
        }

    private fun restore(state: CustomViewState?) {
        buffsLiveData.value = state?.hexCode
    }

    fun startCountDownTimer(timeToShow: Int) {
        countDownTimerLiveData.value = timeToShow
        countDownJob = viewModelScope.launch {
            repeat(timeToShow) {
                val newTime = getCountDownTimerLiveData().value?.minus(1)
                countDownTimerLiveData.postValue(newTime)
                delay(1000)
            }
        }
    }

    fun stopCountDownTimer() = countDownJob.cancel()
}