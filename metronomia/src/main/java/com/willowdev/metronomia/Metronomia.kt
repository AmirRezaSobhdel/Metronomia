package com.willowdev.metronomia

import android.media.AudioManager
import android.media.ToneGenerator
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import java.util.*


class Metronomia(lifecycleOwner: LifecycleOwner) {

    init {
        lifecycleOwner.lifecycle.addObserver(object: LifecycleEventObserver {
            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                when(event)
                {
                    Lifecycle.Event.ON_PAUSE -> {
                        metronomeRepeatingTimer?.cancel()
                    }
                    Lifecycle.Event.ON_STOP -> {
                        metronomeRepeatingTimer?.cancel()
                    }
                }
            }

        })
    }

    private var metronomeRepeatingTimer: Timer? = null

    fun startMetronome(bpm: Int , startDelay: Long = 0)
    {
        metronomeRepeatingTimer?.cancel()
        delayTimeIfNeeded = calculateDelayTimeIfBpmIsChanged(lastBpm , bpm , delayTimeIfNeeded)

        if (startDelay != 0.toLong())
            delayTimeIfNeeded = startDelay

        metronomeRepeatingTimer = Timer()
        metronomeIntervalTime = calculateBeepIntervalTime(bpm)
        metronomeRepeatingTimer?.scheduleAtFixedRate(
            object : TimerTask() {
                override fun run() {
                    metronomeRepeatStartedRepeatingAt = System.currentTimeMillis()
                    val toneG = ToneGenerator(AudioManager.STREAM_ALARM, 80)
                    toneG.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD, 50)
                }
            },  delayTimeIfNeeded,metronomeIntervalTime)

        lastBpm = bpm
    }

    private var lastBpm = 0
    private var delayTimeIfNeeded: Long = 0
    private var metronomeIntervalTime: Long = 0
    private var metronomeRepeatStartedRepeatingAt: Long = 0

    fun pauseMetronome()
    {
        delayTimeIfNeeded = metronomeIntervalTime - (System.currentTimeMillis() - metronomeRepeatStartedRepeatingAt)
        metronomeRepeatingTimer?.cancel()
    }


    fun stopMetronome()
    {
        metronomeRepeatingTimer?.cancel()
    }


    private fun calculateBeepIntervalTime(bpm: Int): Long
    {
        return (60000 / bpm.toFloat()).toLong()
    }

    private fun calculateDelayTimeIfBpmIsChanged(oldBpm: Int , newBpm: Int , lastDelayTimeIfNeeded: Long): Long
    {
        if (oldBpm != newBpm)
        {
            return ((lastDelayTimeIfNeeded*calculateBeepIntervalTime(newBpm))/calculateBeepIntervalTime(oldBpm))
        }
        else return lastDelayTimeIfNeeded
    }
}