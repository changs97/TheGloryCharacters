package com.changs.theglorycharacters.ui

import android.content.Context
import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.changs.theglorycharacters.R
import com.changs.theglorycharacters.databinding.ActivityMainBinding
import com.changs.theglorycharacters.ui.custom.CharacterView
import timber.log.Timber


class MainActivity : AppCompatActivity() {
    // TODO: 분석 해볼 것: 지연 초기화가 아닌 그냥 초기화를 하게 되면 에러가 발생한다. why?
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        Timber.tag("test").d(layoutInflater.toString())
        Timber.tag("test").d((this as Context).toString())
    }
}