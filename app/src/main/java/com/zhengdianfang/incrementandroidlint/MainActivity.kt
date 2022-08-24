package com.zhengdianfang.incrementandroidlint

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Main", "test")
        Log.i("Main", "test")
        Log.i("Main", "test")
        Log.i("Main", "test")
        Log.i("Main", "test")
        findViewById<View>(android.R.id.content).setOnClickListener(View.OnClickListener {
            // todo
        })
    }
}