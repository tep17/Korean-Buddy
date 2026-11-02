package com.example.audio

import android.content.Context
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Locale

class TTSManager(private val context: Context) : TextToSpeech.OnInitListener {

    private var tts: TextToSpeech? = null
    private var isInitialized = false

    private val _isSpeaking = MutableStateFlow(false)
    val isSpeaking: StateFlow<Boolean> = _isSpeaking.asStateFlow()

    private val _currentWord = MutableStateFlow<String?>(null)
    val currentWord: StateFlow<String?> = _currentWord.asStateFlow()

    init {
        try {
            tts = TextToSpeech(context.applicationContext, this)
        } catch (e: Exception) {
            Log.e("TTSManager", "Failed to instantiate TTS", e)
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts?.setLanguage(Locale.KOREAN)
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.w("TTSManager", "Korean language is not supported or missing data on this device TTS engine")
            } else {
                isInitialized = true
                tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                    override fun onStart(utteranceId: String?) {
                        _isSpeaking.value = true
                    }

                    override fun onDone(utteranceId: String?) {
                        _isSpeaking.value = false
                        _currentWord.value = null
                    }

                    @Deprecated("Deprecated in Java")
                    override fun onError(utteranceId: String?) {
                        _isSpeaking.value = false
                        _currentWord.value = null
                    }
                })
            }
        } else {
            Log.e("TTSManager", "TTS initialization failed with status $status")
        }
    }

    fun speak(text: String, isSlow: Boolean = false) {
        if (text.isBlank()) return

        if (!isInitialized || tts == null) {
            Toast.makeText(
                context,
                "Korean audio: $text",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        try {
            _currentWord.value = text
            tts?.setSpeechRate(if (isSlow) 0.65f else 1.0f)
            tts?.setPitch(1.0f)
            val utteranceId = "KoreanBuddy_${System.currentTimeMillis()}"
            tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, utteranceId)
        } catch (e: Exception) {
            Log.e("TTSManager", "Error speaking text", e)
            _isSpeaking.value = false
        }
    }

    fun stop() {
        try {
            tts?.stop()
            _isSpeaking.value = false
            _currentWord.value = null
        } catch (e: Exception) {
            Log.e("TTSManager", "Error stopping TTS", e)
        }
    }

    fun shutdown() {
        try {
            tts?.stop()
            tts?.shutdown()
            tts = null
        } catch (e: Exception) {
            Log.e("TTSManager", "Error shutting down TTS", e)
        }
    }
}
