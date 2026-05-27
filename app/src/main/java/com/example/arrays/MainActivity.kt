package com.example.arrays

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private val numbers = IntArray(10)
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        // DECLARATIONS OF VARIABLES
        val input = findViewById<EditText>(R.id.edtInput)
        val fullSize = findViewById<TextView>(R.id.textMsg)
        val collect = findViewById<Button>(R.id.addBtn)
        val average = findViewById<Button>(R.id.avgBtn)

        val text = "The array is full"

        // setting the average button invisible until array is full
        average.visibility = View.INVISIBLE

        // filling the array when the button ADD is clicked
        collect.setOnClickListener {
            //checking if the array is full
            if (counter >= numbers.size) {
                fullSize.text = text
                average.visibility = View.VISIBLE
                collect.visibility = View.INVISIBLE
                return@setOnClickListener
        }

            // Read user input safely
            val value = input.text.toString().toIntOrNull()

            if (value != null) {
                numbers[counter] = value
                counter++
                input.text.clear()
            } else {
                fullSize.text = "Enter a valid number"
            }
        }
        // calculate the average when clicked
        average.setOnClickListener {
            var total = 0

            for (i in numbers.indices) {
                total += numbers[i]
            }

            val avg = total / numbers.size

            input.setText(avg.toString())
        }





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}