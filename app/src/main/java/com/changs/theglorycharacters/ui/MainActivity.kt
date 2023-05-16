package com.changs.theglorycharacters.ui

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.changs.theglorycharacters.R
import com.changs.theglorycharacters.databinding.ActivityMainBinding
import com.changs.theglorycharacters.ui.custom.CharacterView


class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.lifecycleOwner = this
    }
}