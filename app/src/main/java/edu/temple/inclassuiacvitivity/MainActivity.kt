package edu.temple.inclassuiacvitivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val displayTextView = findViewById<TextView>(R.id.textDisplay)

        /* Step 1: Populate this array */
        //val numberArray = Array Of Numbers
        val numberArray = IntArray(100)
        for (i in 0..99){
            numberArray[i]=i
        }

        for (i in numberArray){
            Log.d("array output", numberArray[i].toString())
        }



        /* Step 2: Create adapter to display items from array in Spinner */
        //spinner.adapter = ArrayAdapter...
        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, numberArray.toList())

        // Step 3: Change TextView's text size to the number selected in the Spinner */
        //spinner.onItemSelectedListener = object: ...
        spinner.onItemSelectedListener = object: OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                /*
                if (p0 != null) {
                    displayTextView.textSize = p0!!.getItemAtPosition(p2).toString().toFloat()
                }
                */
                p0?.run {
                    displayTextView.textSize = getItemAtPosition(p2).toString().toFloat()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                displayTextView.text="lol"
            }
        }

    }
}