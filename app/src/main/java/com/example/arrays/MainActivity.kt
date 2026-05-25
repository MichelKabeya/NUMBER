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
    val input: EditText = findViewById<EditText>(R.id.edtInput)
    // getting input from the user (EditText)
    val value = input.text.toString().toInt()
    fun fillArray(){
        numbers[counter] = value
        counter++
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        // DECLARATIONS OF VARIABLES
        val text = "The array is full"
        var total = 0
        val avg = 0
        val fullSize = findViewById<TextView>(R.id.textMsg)
        val collect = findViewById<Button>(R.id.addBtn)
        val average = findViewById<Button>(R.id.avgBtn)

        // setting the average button invisible until array is full
        average.visibility = View.INVISIBLE

        // filling the array when the button ADD is clicked
        collect.setOnClickListener {
            //checking if the array is full
            if (counter >= numbers.size) {
                fullSize.text = text
                average.visibility = View.VISIBLE
            }
            fillArray()
        }

        counter = 0 // resetting the counter to 0
        // calculate the average when clicked
        average.setOnClickListener {
            total += numbers[counter]
            counter++
        }






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}