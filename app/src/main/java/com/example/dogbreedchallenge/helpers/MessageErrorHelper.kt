package com.example.dogbreedchallenge.helpers

import android.content.Context
import android.widget.Toast

object MessageErrorHelper {
    fun showMessageError(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}