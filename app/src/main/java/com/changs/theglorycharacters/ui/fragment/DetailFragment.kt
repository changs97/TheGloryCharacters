package com.changs.theglorycharacters.ui.fragment

import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.changs.theglorycharacters.R
import com.changs.theglorycharacters.base.BaseFragment
import com.changs.theglorycharacters.data.Character
import com.changs.theglorycharacters.databinding.FragmentDetailBinding

class DetailFragment : BaseFragment<FragmentDetailBinding>(R.layout.fragment_detail) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

/*        val character: Character? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("character", Character::class.java)
        } else {
            intent.getParcelableExtra("character")
        }*/

        postponeEnterTransition()
/*
        character?.let {
            binding.detailTxtDescription.text = character.description
            binding.detailCharacter.apply {
                transitionName = character.id.toString()
                setActorName(character.actor)
                setCharacterName(character.characterName)
                Glide.with(this).load(character.image).listener(object : RequestListener<Drawable> {
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
                }).into(image)
            }
        }*/
    }

}