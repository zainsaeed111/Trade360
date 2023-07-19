package com.example.trade360.BasicFragments
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.trade360.R
import com.example.trade360.databinding.FragmentMainLoginBinding

class MainLogin : Fragment() {

    private var _binding: FragmentMainLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mainLoginBtn.setOnClickListener {
            navigateToRegisterFragment()
        }
    }

    private fun navigateToRegisterFragment() {
        findNavController().navigate(R.id.action_mainLogin_to_mainRegister)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
