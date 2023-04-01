package com.changs.theglorycharacters.ui.fragment

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
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

    }

    override fun onCharacterClicked(view: View, character: Character) {
        view.transitionName = character.id.toString()



/*        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("character", character)

        val options = ActivityOptions
            .makeSceneTransitionAnimation(this, view, character.id.toString())

        startActivity(intent, options.toBundle())*/
    }


}
