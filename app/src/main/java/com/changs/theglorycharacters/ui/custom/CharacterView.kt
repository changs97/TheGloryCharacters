package com.changs.theglorycharacters.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.changs.theglorycharacters.R

class CharacterView : LinearLayout {
    lateinit var characterName: TextView
    lateinit var actorName: TextView
    lateinit var image: ImageView

    constructor(context: Context?) : super(context) {
        initView()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initView()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs) {
        initView()
    }

    private fun initView() {
        val inflaterService = Context.LAYOUT_INFLATER_SERVICE
        val layoutInflater = context.getSystemService(inflaterService) as LayoutInflater
        val view: View = layoutInflater.inflate(R.layout.character_view, this, false)
        addView(view)

        characterName = findViewById(R.id.character_view_txt_character_name)
        actorName = findViewById(R.id.character_view_txt_actor_name)
        image = findViewById(R.id.character_view_img)
    }

}