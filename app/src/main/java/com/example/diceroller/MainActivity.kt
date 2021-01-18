package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)

        //Roll a dice when the button is clicked and add the number in the ImageView
        rollButton.setOnClickListener { rollDice(findViewById(R.id.imageView)) }
        rollDice(findViewById(R.id.imageView))
    }

    /*
    * This function roll a die and put the result of it on a given ImageView.
    * The default number of sides for the die is 6.
    * */

    private fun rollDice(imgV: ImageView, sides: Int = 6): Int {
        val dice = Dice(sides)
        val result = dice.roll()
        val resource: Int = when (result){
            1-> R.drawable.dice_1
            2-> R.drawable.dice_2
            3-> R.drawable.dice_3
            4-> R.drawable.dice_4
            5-> R.drawable.dice_5
            else-> R.drawable.dice_6
        }
        imgV.setImageResource(resource)
        imgV.contentDescription = result.toString()
        return result
    }
}

/*
* Die class to pick a random number given a range.
* */
class Dice(private val sides: Int) {

    fun roll(): Int {
        return (1..sides).random()
    }
}