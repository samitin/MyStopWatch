package ru.samitin.mystopwatch.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import ru.samitin.mystopwatch.model.*

class StopWatchViewModel() : ViewModel() {

    private val timestampProvider = object : TimestampProvider {
        override fun getMilliseconds(): Long {
            return System.currentTimeMillis()
        }
    }
    private val stopwatchListOrchestrator = StopwatchListOrchestrator(
        StopwatchStateHolder(
            StopwatchStateCalculator(timestampProvider, ElapsedTimeCalculator(timestampProvider)),
            ElapsedTimeCalculator(timestampProvider),
            TimestampMillisecondsFormatter()
        ),
        CoroutineScope(Dispatchers.Main + SupervisorJob())
    )
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