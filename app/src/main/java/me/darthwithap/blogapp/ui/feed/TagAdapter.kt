package me.darthwithap.blogapp.ui.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import me.darthwithap.blogapp.R
import me.darthwithap.blogapp.databinding.ListItemTagBinding

class TagAdapter(private val tags: List<String>) :
    RecyclerView.Adapter<TagAdapter.TagViewHolder>() {
    inner class TagViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(tag: String) {
            ListItemTagBinding.bind(itemView).tvTag.text = tag
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagViewHolder {
        return TagViewHolder(
            parent.context.getSystemService(LayoutInflater::class.java).inflate(
                R.layout.list_item_tag,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TagViewHolder, position: Int) {
        holder.bind(tags[position])
    }

    override fun getItemCount() = tags.size

}