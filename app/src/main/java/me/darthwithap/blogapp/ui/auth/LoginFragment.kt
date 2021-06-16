package me.darthwithap.blogapp.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import me.darthwithap.blogapp.AuthViewModel
import me.darthwithap.blogapp.R
import me.darthwithap.blogapp.databinding.FragmentLoginRegisterBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginRegisterBinding? = null
    private val authViewModel: AuthViewModel by activityViewModels()
    val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginRegisterBinding.inflate(inflater, container, false)
        _binding?.tilUsername?.isVisible = true
        _binding?.btnSubmit?.text = this.getString(R.string.login)
        _binding?.tvHeading?.text = this.getString(R.string.login)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            btnSubmit.setOnClickListener {
                authViewModel.login(etEmail.text.toString(), etPassword.text.toString())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}