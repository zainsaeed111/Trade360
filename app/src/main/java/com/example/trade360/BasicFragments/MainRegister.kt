package com.example.trade360.BasicFragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.example.trade360.R
import com.example.trade360.databinding.FragmentMainRegisterBinding
import java.util.regex.Pattern

class MainRegister : Fragment() {

    private var _binding: FragmentMainRegisterBinding? = null
    private val binding get() = _binding!!

    var hasName: Boolean = false
    var hasEmail: Boolean = false
    var hasPassword: Boolean = false
    var hasConfirmPassword: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etFullnameRegister.addTextChangedListener(
            createTextWatcher(
                binding.etFullnameRegister,
                "^[a-zA-Z]+$",
                R.drawable.et_error_bg,
                R.color.primary_red,
                R.drawable.et_enable_bg,
                R.color.grey,
                ::setNameValidation
            )
        )

        binding.etMailRegsiter.addTextChangedListener(
            createTextWatcher(
                binding.etMailRegsiter,
                "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+",
                R.drawable.et_error_bg,
                R.color.primary_red,
                R.drawable.et_enable_bg,
                R.color.grey,
                ::setEmailValidation
            )
        )

        binding.etPassRegister.addTextChangedListener(
            createTextWatcher(
                binding.etPassRegister,
                "^.{8,}$",
                R.drawable.et_error_bg,
                R.color.primary_red,
                R.drawable.et_enable_bg,
                R.color.grey,
                ::setPasswordValidation
            )
        )

        binding.etConfrimPassRegister.addTextChangedListener(
            createTextWatcher(
                binding.etConfrimPassRegister,
                "^${Pattern.quote(binding.etPassRegister.text.toString())}$",
                R.drawable.et_error_bg,
                R.color.primary_red,
                R.drawable.et_enable_bg,
                R.color.grey,
                ::setConfirmPasswordValidation
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun createTextWatcher(
        editText: EditText,
        pattern: String,
        errorBgResId: Int,
        errorTextColorResId: Int,
        validBgResId: Int,
        validTextColorResId: Int,
        validationCallback: (Boolean) -> Unit
    ): TextWatcher {
        return object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val text = s.toString().trim()
                val isValid = text.matches(pattern.toRegex())

                if (text.isEmpty() || !isValid) {
                    editText.background = resources.getDrawable(errorBgResId)
                    editText.setTextColor(resources.getColor(errorTextColorResId))
                    validationCallback(false)
                } else {
                    editText.background = resources.getDrawable(validBgResId)
                    editText.setTextColor(resources.getColor(validTextColorResId))
                    validationCallback(true)
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // If the EditText being watched is the confirm password field,
                // compare the confirm password with the password field.
                if (editText == binding.etConfrimPassRegister) {
                    val confirmPassword = s.toString()
                    val password = binding.etPassRegister.text.toString()

                    setConfirmPasswordValidation(confirmPassword == password)
                }
            }
        }
    }

    private fun setNameValidation(isValid: Boolean) {
        hasName = isValid
    }

    private fun setEmailValidation(isValid: Boolean) {
        hasEmail = isValid
    }

    private fun setPasswordValidation(isValid: Boolean) {
        hasPassword = isValid
    }

    private fun setConfirmPasswordValidation(isValid: Boolean) {
        hasConfirmPassword = isValid

        if (hasConfirmPassword) {
            binding.etConfrimPassRegister.background =
                resources.getDrawable(R.drawable.et_enable_bg)
            binding.etConfrimPassRegister.setTextColor(resources.getColor(R.color.grey))
        } else {
            binding.etConfrimPassRegister.background =
                resources.getDrawable(R.drawable.et_error_bg)
            binding.etConfrimPassRegister.setTextColor(resources.getColor(R.color.primary_red))
        }
    }
}