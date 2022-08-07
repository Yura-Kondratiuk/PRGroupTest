package com.example.prgrouptest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.prgrouptest.R
import com.example.prgrouptest.databinding.FragmentSplashBinding
import com.example.prgrouptest.utils.viewBinding
import com.example.prgrouptest.viewmodels.PrivacyPolicyViewModel
import com.example.prgrouptest.viewmodels.SplashViewModel

class SplashFragment : Fragment(R.layout.fragment_splash) {


    private lateinit var viewModel: SplashViewModel

    private val binding by viewBinding(FragmentSplashBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = SplashViewModel(requireActivity())
      //  findNavController().popBackStack(R.id.fragment_privacy_policy, true)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
        viewModel.isUserAgreed()
    }

    private fun observeData(){
        viewModel.isUserAgreed.observe(viewLifecycleOwner) { isUserAgreed ->
            findNavController().navigate(if (isUserAgreed) {
                R.id.action_to_fragment_web_view
            } else R.id.action_to_fragment_privacy_policy)
        }
    }
}