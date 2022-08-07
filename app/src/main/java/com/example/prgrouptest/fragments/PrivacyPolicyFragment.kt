package com.example.prgrouptest.fragments

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.prgrouptest.R
import com.example.prgrouptest.databinding.FragmentPrivacyPolicyBinding
import com.example.prgrouptest.utils.viewBinding
import com.example.prgrouptest.viewmodels.PrivacyPolicyViewModel

class PrivacyPolicyFragment : Fragment(R.layout.fragment_privacy_policy) {

    private val binding by viewBinding(FragmentPrivacyPolicyBinding::bind)

    private lateinit var viewModel: PrivacyPolicyViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = PrivacyPolicyViewModel(requireActivity())
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initListeners()
    }

    private fun initListeners() {
        with(binding) {
            btnAgree.setOnClickListener {
                viewModel.saveUserAgreed()
                findNavController().navigate(R.id.action_to_fragment_web_view)
            }

            btnExit.setOnClickListener { activity?.finish() }
        }

    }

    private fun initViews() {
        binding.tvPrivacyPolicy.movementMethod = ScrollingMovementMethod()
    }
}