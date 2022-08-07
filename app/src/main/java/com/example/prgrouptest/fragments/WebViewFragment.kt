package com.example.prgrouptest.fragments

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.prgrouptest.R
import com.example.prgrouptest.databinding.FragmentWebViewBinding
import com.example.prgrouptest.utils.isInternetConnection
import com.example.prgrouptest.utils.viewBinding
import com.example.prgrouptest.viewmodels.WebViewViewModel

class WebViewFragment : Fragment(R.layout.fragment_web_view) {

    private val binding by viewBinding(FragmentWebViewBinding::bind)
    private lateinit var viewModel: WebViewViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = WebViewViewModel(requireActivity())
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
        viewModel.getUrl()
        binding.webView.webViewClient = MyWebViewClient()
    }

    private fun observeData() {
        viewModel.url.observe(viewLifecycleOwner) { url ->
            binding.webView.loadUrl(url)
        }
    }

    inner class MyWebViewClient : WebViewClient() {

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
            if (context?.isInternetConnection() ==false){
                findNavController().navigate(R.id.action_to_no_internet)
            }
        }

        override fun onPageFinished(view: WebView, url: String) {
            super.onPageFinished(view, url)
            viewModel.saveUrl(url)
        }
    }

}