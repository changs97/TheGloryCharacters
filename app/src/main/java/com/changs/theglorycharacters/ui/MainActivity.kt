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


class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main), CharacterAdapter.CharacterAdapterListener {
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.homeTxtSee.setOnClickListener {
            val uri = Uri.parse("https://www.netflix.com/kr/title/81519223?source=naver")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        setPager()
    }

    private fun setPager() {
        with(binding.homePager) {
            adapter = CharacterAdapter(this@MainActivity)
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

    override fun onCharacterClicked(view: View, character: Character) {
        view.transitionName = character.id.toString()

        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("character", character)

        val options = ActivityOptions
            .makeSceneTransitionAnimation(this, view, character.id.toString())

        startActivity(intent, options.toBundle())
    }
}