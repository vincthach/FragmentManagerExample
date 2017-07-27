package com.example.thachnguyen.myapplication.features

import com.example.thachnguyen.myapplication.R
import com.example.thachnguyen.myapplication.extensions.openScreenByTag
import kotlinx.android.synthetic.main.fragment_red.*


class RedFragment: BaseFragment() {

    override fun inflateFromLayout(): Int = R.layout.fragment_red

    override fun initViews() {

    }

    override fun initData() {

    }

    override fun initListeners() {
        next.setOnClickListener {
            fragmentManager.openScreenByTag(BlueFragment.TAG, needFindInStack = true)
        }

        prev.setOnClickListener {
            fragmentManager.openScreenByTag(PinkFragment.TAG, needFindInStack = true)
        }
        toolbar.setOnBackClickListener {
            fragmentManager.popBackStack()
        }
    }

    companion object {
        val TAG = "RedFragment"
    }

}