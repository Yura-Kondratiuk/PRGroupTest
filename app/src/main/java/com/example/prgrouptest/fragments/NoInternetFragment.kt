package com.example.prgrouptest.fragments

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.prgrouptest.R
import com.example.prgrouptest.databinding.FragmentNoInternetBinding
import com.example.prgrouptest.utils.isInternetConnection
import com.example.prgrouptest.utils.viewBinding

class NoInternetFragment : DialogFragment(R.layout.fragment_no_internet) {

    private val binding by viewBinding(FragmentNoInternetBinding::bind)

    override fun onStart() {
        super.onStart()
        dialog?.let {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            it.window?.setLayout(width, height)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        binding.btnRefresh.setOnClickListener {
            if (context?.isInternetConnection() == true) {
                findNavController().navigate(R.id.action_to_fragment_splash)
            }
        }
    }
}