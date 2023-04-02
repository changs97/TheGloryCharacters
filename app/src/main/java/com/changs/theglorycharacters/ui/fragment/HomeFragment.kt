package com.changs.theglorycharacters.ui.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.changs.theglorycharacters.R
import com.changs.theglorycharacters.base.BaseFragment
import com.changs.theglorycharacters.data.Character
import com.changs.theglorycharacters.databinding.FragmentHomeBinding
import com.changs.theglorycharacters.ui.adapter.CharacterAdapter
import com.changs.theglorycharacters.ui.custom.CharacterView
import com.changs.theglorycharacters.ui.custom.HorizontalMarginItemDecoration
import com.changs.theglorycharacters.viewmodel.MainViewModel
import kotlin.math.abs

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home), CharacterAdapter.CharacterAdapterListener {
    private val viewModel: MainViewModel by activityViewModels() // 액티비티의 뷰모델을 공유하는게 좋을지 고민

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postponeEnterTransition()

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        setPager()

        binding.homeTxtSee.setOnClickListener {
            // 고민 후 수정
            val uri = Uri.parse("https://www.netflix.com/kr/title/81519223?source=naver")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        (view.parent as? ViewGroup)?.doOnPreDraw {
            binding.homePager.setCurrentItem(viewModel.currentItemPosition, false)
            startPostponedEnterTransition()
        }
    }

    private fun setPager() {
        with(binding.homePager) {
            adapter = CharacterAdapter(this@HomeFragment)
            // 아래 각각의 코드 설명할 수 있도록 하기
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
                requireContext(), R.dimen.viewpager_current_item_horizontal_margin
            )

            addItemDecoration(itemDecoration)
        }
    }

    override fun onCharacterClicked(view: View, character: Character) {
        val directions = HomeFragmentDirections.actionHomeFragmentToDetailFragment(character)
        val extras = FragmentNavigatorExtras(view to view.transitionName)

        findNavController().navigate(
            directions,
            extras
        )
    }

    override fun onPause() {
        viewModel.currentItemPosition = binding.homePager.currentItem
        super.onPause()
    }

}
