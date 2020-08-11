package com.example.wechat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Log 日志打印  调试代码
 * 通过Logcat查看打印的日志内容
 * v  - Verbose
 * d  - Debug
 * i  - Infer
 * e  - Error
 * w  - Warn
 *
 * tag  -  用于设置过滤的标签
 * message - 输出的内容
 */

/**
 * Activity生命周期  ->从创建  ->界面销毁  经历的过程
 * 程序第一次启动
 *   onCreate
 *   onStart
 *   onResume
 * 程序切换到后台
 *   onPause
 *   onStop
 *   程序从后台切换到前台
 *   onRestart
 *   onStart
 *   onResume
 *
 *   按返回键  当前界面会被释放掉
 *   onPause
 *   onStop
 *   onDestroy
 *
 *   切换到其他页面
 *   onPause
 *   onStop
 *
 *   程序从下一个页面切换回来
 *   onRestart
 *   onStart
 *   onResume
 *
 */

class MainActivity : AppCompatActivity() {
    //当Activity被创建  需要对界面进行布局/初始化 调用onCreate方法

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //获取传递过来的数据
        intent.data?.schemeSpecificPart.also {
            //显示到textView中
           mTextView.text = it
        }
        //返回按钮
        mBack.setOnClickListener {
            //回调数据
            Intent().apply {
                putExtra("ShareResult","分享成功")
            }.also {
                setResult(1,it)
                finish()
            }
        }
        Log.v("swl","onCreate")
    }
    //开始启动页面
    override fun onStart() {
        super.onStart()
        Log.v("swl","onStart")
    }
     //重新启动  从后台到前台
    override fun onRestart() {
        super.onRestart()
    }
    //启动完毕 已经展现在用户面前  可以和用户进行交互了
    override fun onResume() {
        super.onResume()
        Log.v("swl","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.v("swl","onPause")
    }

    //界面暂停了
    override fun onStop() {
        super.onStop()
        Log.v("swl","onStop")
    }

    //界面销毁
    override fun onDestroy() {
        super.onDestroy()
        Log.v("swl","onDestroy")
    }
}
