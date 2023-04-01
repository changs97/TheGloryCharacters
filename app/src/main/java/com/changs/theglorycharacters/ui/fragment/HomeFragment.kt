package com.changs.theglorycharacters.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.changs.theglorycharacters.R
import com.changs.theglorycharacters.base.BaseFragment
import com.changs.theglorycharacters.data.Character
import com.changs.theglorycharacters.databinding.FragmentHomeBinding
import com.changs.theglorycharacters.ui.adapter.CharacterAdapter
import com.changs.theglorycharacters.viewmodel.MainViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home), CharacterAdapter.CharacterAdapterListener {
    private val viewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        postponeEnterTransition()

        binding.homeRecycler.adapter = CharacterAdapter(this@HomeFragment)
        binding.homeRecycler.viewTreeObserver.addOnPreDrawListener {
            startPostponedEnterTransition()
            true
        }
    }


    override fun onCharacterClicked(view: View, character: Character) {
        view.transitionName = character.characterName

        val directions = HomeFragmentDirections.actionHomeFragmentToDetailFragment(character)
        val extras = FragmentNavigatorExtras(view to character.characterName)

        findNavController().navigate(
            directions,
            extras
        )
    }

}
