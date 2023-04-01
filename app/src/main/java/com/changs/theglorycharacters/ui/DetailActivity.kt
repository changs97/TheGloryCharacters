package com.changs.theglorycharacters.ui

import android.graphics.drawable.Drawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.window.OnBackInvokedDispatcher
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.changs.theglorycharacters.R
import com.changs.theglorycharacters.base.BaseActivity
import com.changs.theglorycharacters.data.Character
import com.changs.theglorycharacters.databinding.ActivityDetailBinding

class DetailActivity : BaseActivity<ActivityDetailBinding>(R.layout.activity_detail) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val character: Character? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("character", Character::class.java)
        } else {
            intent.getParcelableExtra("character")
        }

        postponeEnterTransition()

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
        }
    }

}