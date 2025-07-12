// This is the main activity file.
// It handles the logic for button clicks, amount calculation, and updating the UI.
package com.example.vangtichai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // UI element references
    private lateinit var takaTextView: TextView
    private lateinit var note500: TextView
    private lateinit var note100: TextView
    private lateinit var note50: TextView
    private lateinit var note20: TextView
    private lateinit var note10: TextView
    private lateinit var note5: TextView
    private lateinit var note2: TextView
    private lateinit var note1: TextView

    // The current amount entered by the user
    private var amount: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI elements
        takaTextView = findViewById(R.id.takaTextView)
        note500 = findViewById(R.id.note500)
        note100 = findViewById(R.id.note100)
        note50 = findViewById(R.id.note50)
        note20 = findViewById(R.id.note20)
        note10 = findViewById(R.id.note10)
        note5 = findViewById(R.id.note5)
        note2 = findViewById(R.id.note2)
        note1 = findViewById(R.id.note1)

        // Initialize buttons
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val button4: Button = findViewById(R.id.button4)
        val button5: Button = findViewById(R.id.button5)
        val button6: Button = findViewById(R.id.button6)
        val button7: Button = findViewById(R.id.button7)
        val button8: Button = findViewById(R.id.button8)
        val button9: Button = findViewById(R.id.button9)
        val button0: Button = findViewById(R.id.button0)
        val clearButton: ImageButton = findViewById(R.id.clearButton)

        // Click listener for number buttons
        val numberClickListener = View.OnClickListener { v ->
            val button = v as Button
            val number = button.text.toString().toInt()
            // Prevent the number from becoming too large (overflow)
            if (amount.toString().length < 15) {
                amount = amount * 10 + number
                updateUI()
            }
        }

        // Set click listeners for all number buttons
        button1.setOnClickListener(numberClickListener)
        button2.setOnClickListener(numberClickListener)
        button3.setOnClickListener(numberClickListener)
        button4.setOnClickListener(numberClickListener)
        button5.setOnClickListener(numberClickListener)
        button6.setOnClickListener(numberClickListener)
        button7.setOnClickListener(numberClickListener)
        button8.setOnClickListener(numberClickListener)
        button9.setOnClickListener(numberClickListener)
        button0.setOnClickListener(numberClickListener)

        // Click listener for the clear button
        clearButton.setOnClickListener {
            amount = 0
            updateUI()
        }

        // Restore the state if the activity was recreated (e.g., on rotation)
        if (savedInstanceState != null) {
            amount = savedInstanceState.getLong("amount")
        }
        // Initial UI update
        updateUI()
    }

    // Save the current amount when the activity is about to be destroyed
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putLong("amount", amount)
    }

    // Update the UI with the current amount and change calculation
    private fun updateUI() {
        takaTextView.text = getString(R.string.taka_label_format, amount)
        calculateChange(amount)
    }

    // Calculate the number of each note required for the given value
    private fun calculateChange(value: Long) {
        var remaining = value
        val notes = listOf(500, 100, 50, 20, 10, 5, 2, 1)
        val textViews = listOf(note500, note100, note50, note20, note10, note5, note2, note1)

        for (i in notes.indices) {
            val count = remaining / notes[i]
            // *** FIX: Set the text to the calculated count, not the label string ***
            textViews[i].text = count.toString()
            remaining %= notes[i]
        }
    }
}
