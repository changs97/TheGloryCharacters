package com.changs.theglorycharacters.ui.custom

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.core.content.withStyledAttributes
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestListener
import com.changs.theglorycharacters.R
import com.changs.theglorycharacters.databinding.CharacterViewBinding


class CharacterView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {
    private val binding = CharacterViewBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        getAttrs(attrs)
    }

    private fun getAttrs(attrs: AttributeSet?) {
        attrs?.let {
            context.withStyledAttributes(
                it, R.styleable.CharacterView
            ) {
                setTypeArray(this)
            }
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun setTypeArray(typedArray: TypedArray) {
        characterNameText = typedArray.getString(R.styleable.CharacterView_characterName).toString()
        characterNameTextColor = typedArray.getColor(
            R.styleable.CharacterView_characterNameColor, R.color.white
        )

        actorNameText = typedArray.getString(R.styleable.CharacterView_actorName).toString()
        actorNameTextColor = typedArray.getColor(
            R.styleable.CharacterView_actorNameColor, R.color.white
        )

        setCharacterImage(typedArray.getDrawable(R.styleable.CharacterView_image))
    }

    var characterNameText: String
        get() = binding.characterViewTxtCharacterName.text.toString()
        set(value) {
            binding.characterViewTxtCharacterName.text = value
        }

    var actorNameText: String
        get() = binding.characterViewTxtActorName.text.toString()
        set(value) {
            binding.characterViewTxtActorName.text = value
        }

    var characterNameTextColor: Int
        get() = binding.characterViewTxtCharacterName.currentTextColor
        set(value) {
            binding.characterViewTxtCharacterName.setTextColor(value)
        }

    var actorNameTextColor: Int
        get() = binding.characterViewTxtActorName.currentTextColor
        set(value) {
            binding.characterViewTxtActorName.setTextColor(value)
        }

    fun setCharacterImage(img: Drawable?, listener: RequestListener<Drawable>? = null) {
        if (listener == null) Glide.with(context).load(img).fitCenter()
            .into(binding.characterViewImg)
        else Glide.with(context).load(img).listener(listener).fitCenter()
            .into(binding.characterViewImg)
    }

    fun setCharacterImage(img: String?, listener: RequestListener<Drawable>? = null) {
        if (listener == null) Glide.with(context).load(img).fitCenter()
            .into(binding.characterViewImg)
        else Glide.with(context).load(img).listener(listener).fitCenter()
            .into(binding.characterViewImg)
    }
}