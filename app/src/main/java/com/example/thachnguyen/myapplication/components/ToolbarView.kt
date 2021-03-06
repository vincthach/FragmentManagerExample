package com.example.thachnguyen.myapplication.components

import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.example.thachnguyen.myapplication.R
import kotlinx.android.synthetic.main.toolbar_view.view.*

class ToolbarView : RelativeLayout {

    var enableBackIcon = false

    var enableNotificationIcon = false

    var toolbarTitle = ""

    constructor(context: Context) : super(context) {
        parseAttrs(null)
        initViews()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        parseAttrs(attrs)
        initViews()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        parseAttrs(attrs)
        initViews()
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        parseAttrs(attrs)
        initViews()
    }

    fun initViews() {
        inflate(this.context, R.layout.toolbar_view, this)

        tvNotificationIcon.visibility = if (enableNotificationIcon) View.VISIBLE else View.GONE
        tvBackIcon.visibility = if (enableBackIcon)  View.VISIBLE else View.GONE
        tvTitle.text = toolbarTitle
    }

    fun parseAttrs(attrs: AttributeSet?) {
        if (attrs != null) {
            val values = context.obtainStyledAttributes(attrs, R.styleable.ToolbarView)
            enableBackIcon = values.getBoolean(R.styleable.ToolbarView_enableBackIcon, false)
            enableNotificationIcon = values.getBoolean(R.styleable.ToolbarView_enableNotificationIcon, false)
            toolbarTitle = values.getString(R.styleable.ToolbarView_toolbarTitle)
            values.recycle()
        }
    }

    fun setOnBackClickListener(onClickListener: () -> Unit) {
        tvBackIcon.setOnClickListener({
            onClickListener()
        })
    }

    fun setOnNotificationClickListener(onClickListener: () -> Unit) {
        tvNotificationIcon.setOnClickListener({
            onClickListener()
        })
    }

    fun setIconRightFromResource(resId: Int) {
        tvNotificationIcon.setText(resId)
    }

    fun setIconLeftFromResource(resId: Int) {
        tvBackIcon.setText(resId)
    }

}
