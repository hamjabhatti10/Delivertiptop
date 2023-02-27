package com.hamza.delivertiptop.ui.activities.splashActivity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowInsets
import android.view.WindowManager
import androidx.lifecycle.ViewModelProvider
import com.hamza.delivertiptop.constant.Constants
import com.hamza.delivertiptop.databinding.ActivitySplashBinding
import com.hamza.delivertiptop.ui.activities.serverSettingActivity.ServerSettingActivity
import com.hamza.delivertiptop.ui.base.BaseActivity
import com.hamza.delivertiptop.utils.PermissionUtils

class SplashActivity : BaseActivity() {
    private var mHandler: Handler? = null
    private lateinit var mActivityIntent: Intent
    private lateinit var mViewModel: SplashViewModel
    private lateinit var mBinding: ActivitySplashBinding
    private val mRunnable: Runnable = Runnable {
        mActivityIntent = Intent(this, ServerSettingActivity::class.java)
        if (!isFinishing) {
            startActivity(mActivityIntent)
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySplashBinding.inflate(layoutInflater)
        switchTheme(true)
        setContentView(mBinding.root)
        PermissionUtils.requestNetworkPermission(this)
        mViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(SplashViewModel::class.java)


    }
}