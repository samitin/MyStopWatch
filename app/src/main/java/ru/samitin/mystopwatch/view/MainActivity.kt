package ru.samitin.mystopwatch.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import ru.samitin.mystopwatch.R
import ru.samitin.mystopwatch.viewModel.StopWatchViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
class MainActivity : AppCompatActivity() {


val viewModel: StopWatchViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.text_time)

            viewModel.liveData.observe(
            this,
            {textView.text=it}
        )

        findViewById<Button>(R.id.button_start).setOnClickListener {
            viewModel.start()
        }
        findViewById<Button>(R.id.button_pause).setOnClickListener {
            viewModel.pause()
        }
        findViewById<Button>(R.id.button_stop).setOnClickListener {
            viewModel.stop()
        }

    }
}
