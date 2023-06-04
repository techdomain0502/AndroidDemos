package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.Toolbar
import androidx.core.view.size
import com.example.myapplication.databinding.ActivityBaseBinding

abstract class BaseActivity : AppCompatActivity() {
    protected lateinit var binding: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_base)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = getActivityTitle()
        val container:LinearLayout = findViewById(R.id.container)
        container.addView( getMainContentView());
    }

   abstract fun getMainContentView(): View?;
   abstract fun getActivityTitle():String;
}