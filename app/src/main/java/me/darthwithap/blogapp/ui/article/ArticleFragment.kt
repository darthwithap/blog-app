package me.darthwithap.blogapp.ui.article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import me.darthwithap.blogapp.R
import me.darthwithap.blogapp.databinding.FragmentArticleBinding

class ArticleFragment : Fragment() {

    private var _binding: FragmentArticleBinding? = null
    private lateinit var articleViewModel: ArticleViewModel
    private var articleId: String? = null

    val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        articleId = arguments?.getString(resources.getString(R.string.arg_article_id))

        articleViewModel = ViewModelProvider(this).get(ArticleViewModel::class.java)
        articleId?.let { articleViewModel.getArticle(it) }

        _binding = FragmentArticleBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        articleViewModel.article.observe({ lifecycle }) {
            _binding?.apply {
                tvTitle.text = it.title
                tvBody.text = it.body
                tvUsernameOrEmail.text = it.author.username
                tvCreatedAt.text = it.createdAt
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}