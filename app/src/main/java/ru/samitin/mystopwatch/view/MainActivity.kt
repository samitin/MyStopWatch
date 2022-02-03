package ru.samitin.mystopwatch.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.samitin.mystopwatch.R
import ru.samitin.mystopwatch.view.app.StopWatchFragment

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container1,StopWatchFragment.newInstanse())
            .commit()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container2,StopWatchFragment.newInstanse())
            .commit()
    }
}
