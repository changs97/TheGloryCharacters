package com.changs.theglorycharacters.ui.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.changs.theglorycharacters.R
import com.changs.theglorycharacters.base.BaseFragment
import com.changs.theglorycharacters.data.Character
import com.changs.theglorycharacters.databinding.FragmentHomeBinding
import com.changs.theglorycharacters.ui.adapter.CharacterAdapter
import com.changs.theglorycharacters.ui.adapter.CharacterAdapterListener
import com.changs.theglorycharacters.ui.custom.HorizontalMarginItemDecoration
import com.changs.theglorycharacters.viewmodel.HomeViewModel
import kotlin.math.abs

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home),
    CharacterAdapterListener {
    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        postponeEnterTransition()
        setPager()

        binding.root.doOnPreDraw {
            binding.homePager.setCurrentItem(viewModel.currentItemPosition, false)
            startPostponedEnterTransition()
        }

        binding.homeTxtSee.setOnClickListener {
            val uri = Uri.parse("https://www.netflix.com/kr/title/81519223")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }

    override fun onPause() {
        viewModel.currentItemPosition = binding.homePager.currentItem
        super.onPause()
    }

    private fun setPager() {
        with(binding.homePager) {
            adapter = CharacterAdapter(this@HomeFragment)

            offscreenPageLimit = 1

            val itemDecoration = HorizontalMarginItemDecoration(
                requireContext(), R.dimen.viewpager_current_item_horizontal_margin
            )

            addItemDecoration(itemDecoration)

            val nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible)
            val currentItemHorizontalMarginPx =
                resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin)
            val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx

            val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
                page.translationX = -pageTranslationX * position
                page.scaleY = 1 - (0.25f * abs(position))
                //page.alpha = 0.25f + (1 - abs(position))
            }

            setPageTransformer(pageTransformer)

        }
    }

    override fun onCharacterClicked(view: View, character: Character) {
        val directions = HomeFragmentDirections.actionHomeFragmentToDetailFragment(character)
        val extras = FragmentNavigatorExtras(view to view.transitionName)

        findNavController().navigate(
            directions, extras
        )
    }

}
