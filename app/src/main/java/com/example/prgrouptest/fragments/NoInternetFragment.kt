package com.example.prgrouptest.fragments

import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.prgrouptest.R

class NoInternetFragment : DialogFragment(R.layout.fragment_no_internet){

    override fun onStart() {
        super.onStart()
        dialog?.let {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            it.window?.setLayout(width, height)
        }
    }
}