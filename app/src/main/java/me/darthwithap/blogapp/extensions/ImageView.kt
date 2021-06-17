package me.darthwithap.blogapp.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

private var url: String? = null

var ImageView.srcUri: String?
    set(value) {
        url = value
        url?.let { Glide.with(this).load(url).into(this) }
    }
    get() = url
