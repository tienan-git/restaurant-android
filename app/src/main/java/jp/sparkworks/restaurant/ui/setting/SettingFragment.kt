package jp.sparkworks.restaurant.ui.setting

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import jp.sparkworks.restaurant.R
import jp.sparkworks.restaurant.ui.setting.settingActivities.AppInfoActivity
import jp.sparkworks.restaurant.ui.setting.settingActivities.FeedbackActivity
import jp.sparkworks.restaurant.ui.setting.settingActivities.LotteryHistoryActivity
import jp.sparkworks.restaurant.ui.setting.settingActivities.SettingLotteryHistory

class SettingFragment : Fragment() {

    private lateinit var settingViewModel: SettingViewModel

    //  応募履歴
    lateinit var lotteryHistory: TextView
    //  フィードバック
    lateinit var feedback: TextView
    // 利用規約
    lateinit var legal: TextView
    // アプリ情報
    lateinit var appInfo: TextView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        settingViewModel = ViewModelProviders.of(this).get(SettingViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_setting, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        settingViewModel.text.observe(this, Observer {
            textView.text = it
        })


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
    }

    private fun initViews(view: View) {

        // 応募履歴
        lotteryHistory = view.findViewById<TextView>(R.id.lottery_history)
        lotteryHistory.setOnClickListener({
            val intent = Intent(activity, LotteryHistoryActivity::class.java)
            startActivity(intent)
        })

        // フィードバック
        feedback = view.findViewById<TextView>(R.id.feedback)
        feedback.setOnClickListener({
            val intent = Intent(activity, FeedbackActivity::class.java)
            startActivity(intent)
        })

        //  利用規約
        legal = view.findViewById<TextView>(R.id.legal)
        legal.setOnClickListener{
            val intent = Intent(activity, FeedbackActivity::class.java)
            startActivity(intent)
        }

        //  アプリ情報
        appInfo = view.findViewById<TextView>(R.id.app_info)
        appInfo.setOnClickListener{
            val intent = Intent(activity, AppInfoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun startSettingActivity(activityName: Class<Any>) {
        val intent = Intent(activity, activityName)
        startActivity(intent)
    }
}