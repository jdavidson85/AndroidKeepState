package com.example.androidkeepstate

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // Declare your views
    private lateinit var textView: TextView
    private lateinit var button: Button
    private lateinit var editText: EditText
    private lateinit var imageView: ImageView
    private lateinit var progressBar: ProgressBar

    // Keys for saving and restoring instance state
    private val TEXTVIEW_STATE_KEY = "textViewState"
    private val EDITTEXT_STATE_KEY = "editTextState"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        editText = findViewById(R.id.editText)
        imageView = findViewById(R.id.imageView)
        progressBar = findViewById(R.id.progressBar)

        // Restore instance state
        if (savedInstanceState != null) {
            textView.text = savedInstanceState.getString(TEXTVIEW_STATE_KEY)
            editText.setText(savedInstanceState.getString(EDITTEXT_STATE_KEY))
        }

        // Set click listener for the button
        button.setOnClickListener {
            textView.text = "Button Clicked"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        // Save instance state
        outState.putString(TEXTVIEW_STATE_KEY, textView.text.toString())
        outState.putString(EDITTEXT_STATE_KEY, editText.text.toString())

        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        // Restore instance state
        textView.text = savedInstanceState.getString(TEXTVIEW_STATE_KEY)
        editText.setText(savedInstanceState.getString(EDITTEXT_STATE_KEY))
    }
}