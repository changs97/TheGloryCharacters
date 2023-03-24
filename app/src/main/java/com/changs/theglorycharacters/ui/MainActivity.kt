package com.changs.theglorycharacters.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.changs.theglorycharacters.R
import com.changs.theglorycharacters.base.BaseActivity
import com.changs.theglorycharacters.databinding.ActivityMainBinding
import com.changs.theglorycharacters.ui.adapter.CharacterAdapter
import com.changs.theglorycharacters.ui.custom.HorizontalMarginItemDecoration
import com.changs.theglorycharacters.viewmodel.MainViewModel
import kotlin.math.abs


class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        setPager()
    }

    fun setPager() {
        with(binding.mainPager) {
            adapter = CharacterAdapter(viewModel)
            offscreenPageLimit = 1

            val nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible)
            val currentItemHorizontalMarginPx =
                resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin)
            val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
            val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
                page.translationX = -pageTranslationX * position
                page.scaleY = 1 - (0.25f * abs(position))
            }

            setPageTransformer(pageTransformer)

            val itemDecoration = HorizontalMarginItemDecoration(
                this@MainActivity, R.dimen.viewpager_current_item_horizontal_margin
            )

            addItemDecoration(itemDecoration)
        }
    }
}