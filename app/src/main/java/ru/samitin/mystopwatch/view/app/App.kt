package ru.samitin.mystopwatch.view.app

import android.app.Application
import org.koin.core.context.startKoin
import ru.samitin.mystopwatch.model.di.model
import ru.samitin.mystopwatch.model.di.svViewModel

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(model, svViewModel))
        }
    }
}