package com.stavros.bettingdemoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import com.stavros.bettingdemoapp.httpRequests.GameHttpRequest
import com.stavros.bettingdemoapp.httpRequests.HeadlinesHttpRequest
import com.stavros.bettingdemoapp.httpRequests.UpdatedGameHttpRequest
import com.stavros.bettingdemoapp.httpRequests.UpdatedHeadLineHttpRequest

import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var timer: Timer
    private val noDelay = 0L
    private val everyFiveSeconds = 2000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
    }

    fun onClickGames(view: View) {
        GameHttpRequest().execute()
    }

    fun onClickHeadlines(view: View) {
        HeadlinesHttpRequest().execute()
    }

    fun onClicGamesUpdates(view: View) {
        UpdatedGameHttpRequest().execute()
    }

    fun onClickHeadlinesUpdate(view: View) {
        UpdatedHeadLineHttpRequest().execute()
    }

    override fun onResume() {
        super.onResume()

        val timerTask = object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    UpdatedHeadLineHttpRequest().execute()
                    UpdatedGameHttpRequest().execute() }
            }
        }

        timer = Timer()
        timer.schedule(timerTask, noDelay, everyFiveSeconds)
    }

    override fun onPause() {
        super.onPause()

        timer.cancel()
        timer.purge()
    }
}