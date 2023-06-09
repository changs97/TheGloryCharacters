package com.changs.theglorycharacters.ui.fragment

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import androidx.transition.TransitionInflater
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.changs.theglorycharacters.R
import com.changs.theglorycharacters.base.BaseFragment
import com.changs.theglorycharacters.databinding.FragmentDetailBinding
import com.changs.theglorycharacters.data.Character

class DetailFragment : BaseFragment<FragmentDetailBinding>(R.layout.fragment_detail) {
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val transition = TransitionInflater.from(requireContext())
            .inflateTransition(R.transition.shared_character)
        sharedElementEnterTransition = transition
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postponeEnterTransition()
        setCharacter(args.character)
    }

    private fun setCharacter(character: Character) {
        binding.detailTxtDescription.text = character.description
        binding.detailCharacter.apply {
            transitionName = character.characterName
            actorNameText = character.actor
            characterNameText = character.characterName

            setCharacterImage(character.image, object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    startPostponedEnterTransition()
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    startPostponedEnterTransition()
                    return false
                }
            })
        }
    }
}