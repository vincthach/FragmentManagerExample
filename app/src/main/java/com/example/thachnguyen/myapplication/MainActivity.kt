package com.example.thachnguyen.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.thachnguyen.myapplication.extensions.openScreenByTag
import com.example.thachnguyen.myapplication.features.BlueFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.openScreenByTag(BlueFragment.TAG)
    }
}
