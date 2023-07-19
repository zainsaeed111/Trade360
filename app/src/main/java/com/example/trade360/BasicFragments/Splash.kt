package com.example.trade360.BasicFragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.navigation.fragment.findNavController
import com.example.trade360.R
import com.example.trade360.databinding.FragmentSplashBinding


class Splash : Fragment() {

    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         binding = FragmentSplashBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.window?.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        // Delay for 3 seconds using a Handler
        Handler(Looper.getMainLooper()).postDelayed({
            navigateToMainFragment()
        }, 3000) // Delay in milliseconds (e.g., 3000 for 3 seconds)
    }

    private fun navigateToMainFragment() {
        findNavController().navigate(R.id.action_splash_to_mainLogin)

    }


}