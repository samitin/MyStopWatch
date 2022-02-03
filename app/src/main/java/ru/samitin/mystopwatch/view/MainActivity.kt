package ru.samitin.mystopwatch.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import ru.samitin.mystopwatch.R
import ru.samitin.mystopwatch.viewModel.StopWatchViewModel

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.text_time)
        val viewModel= ViewModelProvider(this).get(StopWatchViewModel::class.java)
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
