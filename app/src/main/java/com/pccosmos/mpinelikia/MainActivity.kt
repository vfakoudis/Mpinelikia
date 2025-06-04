package com.pccosmos.mpinelikia

import android.media.MediaPlayer
import android.os.Bundle
import android.provider.MediaStore.Audio
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var Audio1: MediaPlayer? = null
    private var Audio2: MediaPlayer? = null
    private var Audio3: MediaPlayer? = null
    private var Audio4: MediaPlayer? = null
    private var Audio5: MediaPlayer? = null
    private var Audio6: MediaPlayer? = null
    private var Audio7: MediaPlayer? = null
    private var Audio8: MediaPlayer? = null
    private var Audio9: MediaPlayer? = null
    private var Audio10: MediaPlayer? = null
    private var Audio11: MediaPlayer? = null
    private var Audio12: MediaPlayer? = null
    private var Audio13: MediaPlayer? = null
    private var Audio14: MediaPlayer? = null
    private var Audio15: MediaPlayer? = null
    private var Audio16: MediaPlayer? = null
    private var Audio17: MediaPlayer? = null
    private var Audio18: MediaPlayer? = null
    private var Audio19: MediaPlayer? = null
    private var Audio20: MediaPlayer? = null
    private var Audio21: MediaPlayer? = null
    private var Audio22: MediaPlayer? = null
    private var Audio23: MediaPlayer? = null
    private var Audio24: MediaPlayer? = null

    private var AudioList: List<MediaPlayer?> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize the MediaPlayers only once
        Audio1 = MediaPlayer.create(this, R.raw.audio1)
        Audio2 = MediaPlayer.create(this, R.raw.audio2)
        Audio3 = MediaPlayer.create(this, R.raw.audio3)
        Audio4 = MediaPlayer.create(this, R.raw.audio4)
        Audio5 = MediaPlayer.create(this, R.raw.audio5)
        Audio6 = MediaPlayer.create(this, R.raw.audio6)
        Audio7 = MediaPlayer.create(this, R.raw.audio7)
        Audio8 = MediaPlayer.create(this, R.raw.audio8)
        Audio9 = MediaPlayer.create(this, R.raw.audio9)
        Audio10 = MediaPlayer.create(this, R.raw.audio10)
        Audio11 = MediaPlayer.create(this, R.raw.audio11)
        Audio12 = MediaPlayer.create(this, R.raw.audio12)
        Audio13 = MediaPlayer.create(this, R.raw.audio13)
        Audio14 = MediaPlayer.create(this, R.raw.audio14)
        Audio15 = MediaPlayer.create(this, R.raw.audio15)
        Audio16 = MediaPlayer.create(this, R.raw.audio16)
        Audio17 = MediaPlayer.create(this, R.raw.audio17)
        Audio18 = MediaPlayer.create(this, R.raw.audio18)
        Audio19 = MediaPlayer.create(this, R.raw.audio19)
        Audio20 = MediaPlayer.create(this, R.raw.audio20)
        Audio21 = MediaPlayer.create(this, R.raw.audio21)
        Audio22 = MediaPlayer.create(this, R.raw.audio22)
        Audio23 = MediaPlayer.create(this, R.raw.audio23)
        Audio24 = MediaPlayer.create(this, R.raw.audio24)
        AudioList = listOf(Audio2, Audio3, Audio4, Audio5, Audio6, Audio7, Audio8, Audio9, Audio10, Audio11, Audio12, Audio13, Audio14, Audio15, Audio16, Audio17, Audio18, Audio19, Audio20, Audio21, Audio22, Audio23, Audio24)
    }

    fun vrise(view: View) {
        // Check if any audio is playing
        if (AudioList.any { it?.isPlaying == true }) {
            Toast.makeText(this, "Κάτσε ντε! Πόσο βρ🔪💣💥δι θες πια;!", Toast.LENGTH_SHORT).show()
            return
        }

        // Start a random audio
        AudioList.random()?.start()
    }
}