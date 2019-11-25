package jp.sparkworks.restaurant.ui.lottery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import jp.sparkworks.restaurant.R

class LotteryFragment : Fragment() {

    private lateinit var lotteryViewModel: LotteryViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        lotteryViewModel = ViewModelProviders.of(this).get(LotteryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_lottery, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        lotteryViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}