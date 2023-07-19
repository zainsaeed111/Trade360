package com.example.trade360.MainDashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.trade360.R
import com.example.trade360.databinding.FragmentHomeDashboardBinding


class HomeDashboard : Fragment() {

    private lateinit var binding:FragmentHomeDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentHomeDashboardBinding.inflate(layoutInflater,container,false)
        return  binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}