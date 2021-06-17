package me.darthwithap.blogapp.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import me.darthwithap.blogapp.R
import me.darthwithap.blogapp.databinding.FragmentFeedBinding

class MyFeedFragment : Fragment() {

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
        feedViewModel.updateMyFeed()
        _binding = FragmentFeedBinding.inflate(inflater, container, false)

        feedAdapter = FeedAdapter()

        _binding?.rvFeed?.layoutManager =
            LinearLayoutManager(context)
        _binding?.rvFeed?.adapter = feedAdapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        feedViewModel.myFeed.observe(viewLifecycleOwner) {
            feedAdapter.submitList(it)
        }

        // add onArticleItemClickListener to the adapter
        feedAdapter.setOnArticleItemClickListener(object : FeedAdapter.OnArticleItemClickListener {
            override fun onArticleItemClicked(slug: String) {
                openArticle(slug)
            }

        })
    }

    fun openArticle(articleId: String) {
        findNavController().navigate(
            R.id.action_nav_my_feed_to_nav_article,
            bundleOf(resources.getString(R.string.arg_article_id) to articleId)
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}