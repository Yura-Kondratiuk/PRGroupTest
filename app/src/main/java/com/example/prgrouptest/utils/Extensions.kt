package com.example.prgrouptest.utils

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty


fun <T : ViewBinding> Fragment.viewBinding(factory: (View) -> T): ReadOnlyProperty<Fragment, T> =
    object : ReadOnlyProperty<Fragment, T>, DefaultLifecycleObserver {
        private var binding: T? = null

        override fun getValue(thisRef: Fragment, property: KProperty<*>): T =
            binding ?: factory(requireView()).also {
                // if binding is accessed after Lifecycle is DESTROYED, create new instance, but don't cache it
                if (viewLifecycleOwner.lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED)) {
                    viewLifecycleOwner.lifecycle.addObserver(this)
                    binding = it
                }
            }

        override fun onDestroy(owner: LifecycleOwner) {
            binding = null
        }
    }

fun Context.isInternetConnection(): Boolean {
    val manager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager?
    val i = manager!!.activeNetworkInfo
    return i != null && i.isConnected && i.isAvailable
}
