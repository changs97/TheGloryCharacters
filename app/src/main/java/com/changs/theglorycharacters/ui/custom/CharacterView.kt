package com.changs.theglorycharacters.ui.custom

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.changs.theglorycharacters.R


class CharacterView(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {
    lateinit var characterName: TextView
    lateinit var actorName: TextView
    lateinit var image: ImageView


    init {
        initView()
        getAttrs(attrs)
    }

    private fun initView() {
        val inflaterService = Context.LAYOUT_INFLATER_SERVICE
        val layoutInflater = context.getSystemService(inflaterService) as LayoutInflater
        val view: View = layoutInflater.inflate(
            R.layout.character_view, this, false
        )
        addView(view)

        characterName = findViewById(R.id.character_view_txt_character_name)
        actorName = findViewById(R.id.character_view_txt_actor_name)
        image = findViewById(R.id.character_view_img)
    }

    private fun getAttrs(attrs: AttributeSet?) {
        val typedArray = context.obtainStyledAttributes(
            attrs, R.styleable.CharacterView
        )
        setTypeArray(typedArray)
    }

    @SuppressLint("ResourceAsColor")
    private fun setTypeArray(typedArray: TypedArray) {
        try {
            characterName.text = typedArray.getString(R.styleable.CharacterView_characterName)
            characterName.setTextColor(
                typedArray.getColor(
                    R.styleable.CharacterView_characterNameColor, R.color.white
                )
            )
            actorName.text = typedArray.getString(R.styleable.CharacterView_actorName)
            actorName.setTextColor(
                typedArray.getColor(
                    R.styleable.CharacterView_actorNameColor, R.color.white
                )
            )
            image.setImageDrawable(typedArray.getDrawable(R.styleable.CharacterView_image))
        } finally {
            typedArray.recycle()
        }
    }

    fun setCharacterName(text: String) {
        characterName.text = text
    }

    fun setActorName(text: String) {
        actorName.text = text
    }


    fun setCharacterNameColor(color: Int) {
        characterName.setTextColor(ContextCompat.getColor(context, color))
    }

    fun setActorNameColor(color: Int) {
        actorName.setTextColor(ContextCompat.getColor(context, color))
    }

}