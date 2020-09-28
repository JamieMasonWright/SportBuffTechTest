package com.jaymason.sportbuff

import android.os.Bundle
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(video)
        video.setMediaController(mediaController)
        video.setVideoPath(BuildConfig.VIDEO_URL)
        video.start()
    }

}