package ru.samitin.mystopwatch.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import ru.samitin.mystopwatch.model.*

class StopWatchViewModel(private val stopwatchListOrchestrator:StopwatchListOrchestrator) : ViewModel() {


    val liveData: LiveData<String> =stopwatchListOrchestrator.ticker.asLiveData()
    fun start(){
        stopwatchListOrchestrator.start()
    }
    fun pause(){
        stopwatchListOrchestrator.pause()
    }
    fun stop(){
        stopwatchListOrchestrator.stop()
    }
}