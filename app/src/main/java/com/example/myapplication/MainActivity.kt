package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View
import android.widget.TextView
    import android.util.Log
    import android.widget.Toast
// 수업 시간에 연습 중 헤헤
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("Activity Lifecycle", "Edited MainActivity Start")
    }
    

    private var count = 0
    private var resumedAfterPause = false

    override fun onPause() {
        super.onPause()
        val pauseMsg = "Reset count"
        Toast.makeText(this, pauseMsg, Toast.LENGTH_LONG).show()
        count = 0
        resumedAfterPause = true
    }

    override fun onResume() {
        super.onResume()
        val tv1 = findViewById<TextView>(R.id.myTextView)
        if (resumedAfterPause) {
            tv1.text = "Resumed with count $count"
            resumedAfterPause = false
        }
    }

    fun buttonClicked(view: View) {
        count++
        val tv1 = findViewById<TextView>(R.id.myTextView)
        tv1.text = "Count: $count"
    }
}