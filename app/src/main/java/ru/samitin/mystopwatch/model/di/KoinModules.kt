package ru.samitin.mystopwatch.model.di

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.samitin.mystopwatch.model.*
import ru.samitin.mystopwatch.viewModel.StopWatchViewModel



val model = module {
    factory <StopwatchStateHolder>{ StopwatchStateHolder(get(), get(), TimestampMillisecondsFormatter()) }
    factory <StopwatchStateCalculator>{  StopwatchStateCalculator(get(),get()) }
    factory <ElapsedTimeCalculator>{ ElapsedTimeCalculator(get()) }
    factory<TimestampProvider> {object : TimestampProvider {
        override fun getMilliseconds(): Long {
            return System.currentTimeMillis()
        }
    } }
}
val svViewModel = module {
    factory <StopwatchListOrchestrator> {
        StopwatchListOrchestrator(get(), CoroutineScope(Dispatchers.Main + SupervisorJob()))
    }
    viewModel { StopWatchViewModel(get())}
}
