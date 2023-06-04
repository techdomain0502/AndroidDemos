package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelLazy
import com.example.myapplication.databinding.ActivityDerivedBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

abstract class BaseSyncSettingsActivity : BaseActivity() {

    private val mainViewModel: MainViewModel by ViewModelLazy(
        MainViewModel::class,
        { viewModelStore },
        { defaultViewModelProviderFactory }
    )

    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getMainContentView(): View? {
        val binding: ActivityDerivedBinding = DataBindingUtil.inflate(layoutInflater,R.layout.activity_derived,null,false);
        binding.lifecycleOwner = this
        binding.viewModel = mainViewModel
        //emulate network delay
        coroutineScope.launch {
            delay(1500)
            mainViewModel.status.postValue("syncing..");

            delay(1500)
            mainViewModel.status.postValue("last syned at x/y/zzzz hh::mm::ss..");
        }
        return binding.root
    }
}