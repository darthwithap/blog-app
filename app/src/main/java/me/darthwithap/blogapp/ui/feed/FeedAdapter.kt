package me.darthwithap.blogapp.ui.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import me.darthwithap.api.models.entities.Article
import me.darthwithap.blogapp.databinding.ListItemArticleBinding

class FeedAdapter : ListAdapter<Article, FeedAdapter.FeedViewHolder>(
    object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.toString() == newItem.toString()
        }

    }
) {
    private var clickListener: OnArticleItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val binding = ListItemArticleBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FeedViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(article: Article) {
            ListItemArticleBinding.bind(itemView).apply {
                with(article) {
                    tvTitle.text = title
                    tvCreatedAt.text = updatedAt
                    tvDescription.text = description
                    tvFavoriteCount.text = favoritesCount.toString()
                    tvUsernameOrEmail.text = author.username
                    //Add author profile image using glide or picasso
                    rvTags.layoutManager = LinearLayoutManager(
                        rvTags.context,
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )
                    rvTags.adapter = TagAdapter(tagList)

                    root.setOnClickListener {
                        clickListener?.onArticleItemClicked(article.slug)
                    }
                }
            }
        }
    }

    interface OnArticleItemClickListener {
        fun onArticleItemClicked(slug: String)
    }

    fun setOnArticleItemClickListener(listener: OnArticleItemClickListener) {
        clickListener = listener
    }
}