package com.example.dogbreedchallenge.helpers

import android.widget.ImageView
import com.squareup.picasso.Picasso

object ImageLoadHelper {
    fun ImageView.loadImageFromURL(url: String) {
        Picasso.get().load(url).into(this)
    }
}