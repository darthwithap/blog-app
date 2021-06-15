package me.darthwithap.blogapp.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.tabs.TabLayout
import me.darthwithap.blogapp.AuthViewModel
import me.darthwithap.blogapp.R
import me.darthwithap.blogapp.databinding.FragmentAuthBinding

class AuthFragment : Fragment() {

    private var _binding: FragmentAuthBinding? = null
    private var navController: NavController? = null
    private lateinit var authViewModel: AuthViewModel

    val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAuthBinding.inflate(inflater, container, false)
        authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)

        navController =
            _binding?.let { Navigation.findNavController(it.root.findViewById(R.id.authFragmentNavHost)) }

        _binding?.authTabLayout?.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
                        navController?.navigate(R.id.gotoLoginFragment)
                    }
                    1 -> {
                        navController?.navigate(R.id.gotoRegisterFragment)
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}