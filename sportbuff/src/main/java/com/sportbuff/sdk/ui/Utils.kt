package com.sportbuff.sdk.ui

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable

object Utils {
    fun resize(context: Context, image: Drawable, radius: Int): Drawable? {
        val b = (image as BitmapDrawable).bitmap
        val bitmapResized = Bitmap.createScaledBitmap(b, radius, radius, false)
        return BitmapDrawable(context.resources, bitmapResized)
    }
}