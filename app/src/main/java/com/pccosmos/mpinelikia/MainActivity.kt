package com.pccosmos.mpinelikia

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresPermission
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

    // It's better to get the ImageButton reference in onCreate
    private lateinit var randomButton: ImageButton
    private var AudioList: List<MediaPlayer?> = listOf()
    private val imageChangeHandler = Handler(Looper.getMainLooper())
    private var imageChangeRunnable: Runnable? = null // To manage canceling previous runnables

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Assuming your ImageButton in activity_main.xml has the id "random_sound_button"
        // Replace "random_sound_button" with the actual ID of your ImageButton
        randomButton = findViewById(R.id.imageButton)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

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
        AudioList = listOf(Audio1, Audio2, Audio3, Audio4, Audio5, Audio6, Audio7, Audio8, Audio9, Audio10, Audio11, Audio12, Audio13, Audio14, Audio15, Audio16, Audio17, Audio18, Audio19, Audio20, Audio21, Audio22, Audio23, Audio24)

        // Set the initial image for the button
        randomButton.setImageResource(R.drawable.press) // Assuming 'press.png' is in res/drawable
        // If 'press' is from R.raw, it's not an image resource.
        // ImageButton expects drawable resources.
    }

    @RequiresPermission(Manifest.permission.VIBRATE)
    @Suppress("DEPRECATION")
    fun Context.vibrator(durationMillis: Long = 50) {
        when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
                val vibratorManager = getSystemService(VIBRATOR_MANAGER_SERVICE) as VibratorManager
                val vibrationEffect = VibrationEffect.createOneShot(durationMillis, VibrationEffect.DEFAULT_AMPLITUDE)
                val vibrator = vibratorManager.defaultVibrator
                vibrator.vibrate(vibrationEffect)
            }
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && Build.VERSION.SDK_INT < Build.VERSION_CODES.S -> {
                val vibrator = getSystemService(VIBRATOR_SERVICE) as Vibrator
                val vibrationEffect = VibrationEffect.createOneShot(durationMillis, VibrationEffect.DEFAULT_AMPLITUDE)
                vibrator.vibrate(vibrationEffect)
            }
            else -> {
                val vibrator = getSystemService(VIBRATOR_SERVICE) as Vibrator
                vibrator.vibrate(durationMillis)
            }
        }
    }

    fun vrise(view: View) {
        // --- Image Change Logic (Stays the Same) ---
        randomButton.setImageResource(R.drawable.pressed) // Use your actual drawable resource ID

        imageChangeRunnable?.let { imageChangeHandler.removeCallbacks(it) }
        imageChangeRunnable = Runnable {
            randomButton.setImageResource(R.drawable.press) // Use your actual drawable resource ID
        }
        imageChangeHandler.postDelayed(imageChangeRunnable!!, 2000)

        // --- Sound Logic ---
        if (AudioList.any { it!!.isPlaying }) { // Check non-nullable list for clarity
            vibrator(200)
            Toast.makeText(this, "Κάτσε ντε! Πόσο βρ🔪💣💥δι θες πια;!", Toast.LENGTH_SHORT).show()
            // Optional: you might want to return here if you DON'T want to play a new sound
            // if another is already playing and reset its 2-second timer.
            // If you want to stop the current and play a new one, you'd add stop logic here.
            return
        } else {
            // Only play a new sound if nothing else is playing
            val soundToPlay = AudioList.filter { it!!.isPrepared() } // Ensure you only pick prepared players
                .randomOrNull() // Get a random one, or null if list is empty or no prepared

            if (soundToPlay != null) {
                try {
                    soundToPlay.start() // Start the randomly selected sound
                    vibrator(100)
                } catch (e: IllegalStateException) {
                    Log.e("MainActivity", "Failed to start MediaPlayer", e)
                    Toast.makeText(this, "Error playing sound", Toast.LENGTH_SHORT).show()
                    // You might want to try and reset the player or re-initialize it here
                }
            } else {
                Log.w("MainActivity", "No available or prepared sounds to play.")
                // Optionally, inform the user if no sounds are available
                // Toast.makeText(this, "No sounds available to play.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // These functions should likely be outside `vrise` if they are general utility
// or called from other places (like an onClick for a different button).
// If they are ONLY for `vrise`, their placement was just ineffective.
    fun openURL(link: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://$link"))
        startActivity(intent)
    }

    fun visitpcc(view: View) { // Assuming this is for a different button's onClick
        openURL("pccosmos.gr")
    }

    // It's good practice to have a helper for checking if a player is prepared
// if you aren't using MediaPlayer.create() which prepares synchronously.
// However, since you are using create(), they should be prepared.
// This is more for future-proofing or if you change initialization.
    private fun MediaPlayer.isPrepared(): Boolean {
        return try {
            // A bit of a hacky way to check if prepared without an internal flag
            // Calling isPlaying or getDuration on an unprepared player throws IllegalStateException
            this.duration
            true
        } catch (e: IllegalStateException) {
            false
        }
    }}