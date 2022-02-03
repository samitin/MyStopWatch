package ru.samitin.mystopwatch.view.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.samitin.mystopwatch.R
import ru.samitin.mystopwatch.viewModel.StopWatchViewModel

class StopWatchFragment : Fragment() {
    companion object{
        fun newInstanse()=StopWatchFragment()
    }

    val viewModel: StopWatchViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView = view.findViewById<TextView>(R.id.text_time)

        viewModel.liveData.observe(
            viewLifecycleOwner,
            {textView.text=it}
        )

        view.findViewById<Button>(R.id.button_start).setOnClickListener {
            viewModel.start()
        }
        view.findViewById<Button>(R.id.button_pause).setOnClickListener {
            viewModel.pause()
        }
        view.findViewById<Button>(R.id.button_stop).setOnClickListener {
            viewModel.stop()
        }
    }
}