package com.example.thachnguyen.myapplication.extensions

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.util.Log
import com.example.thachnguyen.myapplication.R
import com.example.thachnguyen.myapplication.features.BlueFragment
import com.example.thachnguyen.myapplication.features.PinkFragment
import com.example.thachnguyen.myapplication.features.RedFragment

fun FragmentManager.openScreenByTag(tag:String, containerId: Int = R.id.fl_container, needFindInStack: Boolean = false, bundle: Bundle? = null) {
    val fragment = createFragmentByTAG(tag)
    fragment?.arguments = bundle
    when(fragment) {
        null -> Log.e("FragmentManager", "Can not create fragment by tag ${tag}")
        else -> attachFragment(containerId, fragment, tag, needFindInStack)
    }
}


private fun createFragmentByTAG(tag: String) : Fragment? = when(tag) {
    BlueFragment.TAG -> BlueFragment()
    RedFragment.TAG -> RedFragment()
    PinkFragment.TAG -> PinkFragment()
    else -> null
}

private fun FragmentManager.addNewFragment(containerId: Int, fragment: Fragment, tag: String) {
    val transaction = this.beginTransaction()
    transaction.add(containerId, fragment, tag)
            .addToBackStack(tag)
            .commit()
}

private fun FragmentManager.attachFragment(containerId: Int,
                                           fragment: Fragment,
                                           tag: String,
                                           needFindInStack: Boolean) {
    when (needFindInStack) {
        false -> this.addNewFragment(containerId, fragment, tag)
        else -> {
            val previousFragment = this.findFragmentByTag(tag)
            if (previousFragment == null) {
                this.addNewFragment(containerId, fragment, tag)
            } else {
                this.beginTransaction()
                        .replace(containerId, previousFragment, tag)
                        .addToBackStack(tag)
                        .commit()
            }
        }
    }
}
