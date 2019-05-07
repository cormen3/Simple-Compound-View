package hossein.gheisary.compoundview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.custom_layout.view.*

class CustomView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
        ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        View.inflate(context, R.layout.custom_layout, this)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomView)
        try {
            val text = typedArray.getString(R.styleable.CustomView_text)
            val drawableId = typedArray.getResourceId(R.styleable.CustomView_image, 0)
            if (drawableId != 0) {
                val drawable = AppCompatResources.getDrawable(context, drawableId)
                image_thumb.setImageDrawable(drawable)
            }
            text_title.text = text
        } finally {
            typedArray.recycle()
        }
    }
}
