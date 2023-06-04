package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DetailSyncSettingsActivity : BaseSyncSettingsActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun getActivityTitle(): String {
       return "Internet Settings";
    }
}