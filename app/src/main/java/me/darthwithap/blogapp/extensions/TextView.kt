package me.darthwithap.blogapp.extensions

import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
import android.widget.TextView
import java.util.*

@SuppressLint("ConstantLocale")
val isoDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())

@SuppressLint("ConstantLocale")
val dateFormat = SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault())

var TextView.timestamp: String
    set(value) {
        val date = isoDateFormat.parse(value)
        text = dateFormat.format(date)
    }
    get() {
        val date = dateFormat.parse(text.toString())
        return isoDateFormat.format(date)
    }