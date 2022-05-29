package com.example.fragmentcommunikotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fragmentcommunikotlin.fragment.FirstFragment
import com.example.fragmentcommunikotlin.fragment.SecondFragment

class RuntimeActivity : AppCompatActivity(), FirstFragment.FirstListner,
    SecondFragment.SecondListener {

    lateinit var secondFragment: SecondFragment
    lateinit var firstFragment: FirstFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_runtime)
        initViews()
    }

    override fun onFirstSend(str: String) {
        secondFragment.updateSeconText(str)
    }

    override fun onSecondSend(str: String) {
        firstFragment.updateFirstText(str)
    }

    fun initViews() {
        firstFragment = FirstFragment()
        secondFragment = SecondFragment()
        supportFragmentManager.beginTransaction().replace(
            R.id.firstfragnent,
            firstFragment
        ).replace(R.id.secondfragment, secondFragment).commit()
    }
}