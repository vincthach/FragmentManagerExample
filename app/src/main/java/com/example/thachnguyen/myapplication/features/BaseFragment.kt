package com.example.thachnguyen.myapplication.features

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.thachnguyen.myapplication.actions.BaseInitAction

abstract class BaseFragment : Fragment(), BaseInitAction {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(inflateFromLayout(), container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initListeners()
        initData()
    }

    abstract fun inflateFromLayout() : Int


}