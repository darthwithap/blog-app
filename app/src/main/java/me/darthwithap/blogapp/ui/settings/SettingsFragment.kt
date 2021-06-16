package me.darthwithap.blogapp.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import me.darthwithap.blogapp.AuthViewModel
import me.darthwithap.blogapp.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private val authViewModel: AuthViewModel by activityViewModels()
    private var _binding: FragmentSettingsBinding? = null
    val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            authViewModel.user.observe({ lifecycle }) {
                etImageUrl.setText(it?.image)
                etBio.setText(it?.bio)
                etUsername.setText(it?.username)
                etEmail.setText(it?.email)
            }

            btnSave.setOnClickListener {
                authViewModel.update(
                    etImageUrl.text.toString(),
                    etBio.text.toString(),
                    etUsername.text.toString().takeIf { it.isNotBlank() },
                    etEmail.text.toString().takeIf { it.isNotBlank() },
                    etPassword.text.toString().takeIf { it.isNotBlank() }
                )
            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}