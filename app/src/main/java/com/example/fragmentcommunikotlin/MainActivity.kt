package com.example.fragmentcommunikotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    fun initView() {
        var b_open = findViewById<Button>(R.id.b_open)
        b_open.setOnClickListener{
            //openFragmentActivity()
            openRuntimeActivity()

        }
    }
    fun  openFragmentActivity(){
        var initent=Intent(this,FragmentActivity::class.java)
        startActivity(initent)
    }
    fun  openRuntimeActivity(){
        var initent=Intent(this,RuntimeActivity::class.java)
        startActivity(initent)
    }
}