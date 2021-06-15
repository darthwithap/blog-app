package me.darthwithap.blogapp.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import me.darthwithap.blogapp.databinding.FragmentFeedBinding

class GlobalFeedFragment : Fragment() {

    private lateinit var feedViewModel: FeedViewModel
    private var _binding: FragmentFeedBinding? = null
    private lateinit var feedAdapter: FeedAdapter

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        feedViewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        feedViewModel.updateGlobalFeed()
        _binding = FragmentFeedBinding.inflate(inflater, container, false)
        feedAdapter = FeedAdapter()
        _binding?.rvFeed?.layoutManager =
            LinearLayoutManager(context)
        _binding?.rvFeed?.adapter = feedAdapter
        feedViewModel.feed.observe(viewLifecycleOwner) {
            feedAdapter.submitList(it)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}