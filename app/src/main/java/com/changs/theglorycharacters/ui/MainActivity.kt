package com.changs.theglorycharacters.ui

import android.app.ActivityOptions
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.changs.theglorycharacters.R
import com.changs.theglorycharacters.base.BaseActivity
import com.changs.theglorycharacters.data.Character
import com.changs.theglorycharacters.databinding.ActivityMainBinding
import com.changs.theglorycharacters.ui.adapter.CharacterAdapter
import com.changs.theglorycharacters.viewmodel.MainViewModel
import kotlin.math.abs


class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val viewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel


    }
}