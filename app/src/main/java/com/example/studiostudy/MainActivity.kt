package com.example.studiostudy

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Layout
import kotlin.random.Random

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val leftbutton: Button = findViewById(R.id.btnLeft)
        val rightbutton: Button = findViewById(R.id.btnRight)
        val layout: ConstraintLayout = findViewById(R.id.background)


        fun checkAnswer(isLeftButtonSelected:Boolean) {
            val leftNum = leftbutton.text.toString().toInt()
            val rightNum = rightbutton.text.toString().toInt()
            val isAnswerCorrect: Boolean = if (isLeftButtonSelected) leftNum > rightNum else rightNum > leftNum
            if(isAnswerCorrect) {
                layout.setBackgroundColor(Color.GREEN)
                Toast.makeText(this,"Correct!!", Toast.LENGTH_SHORT).show()
            }
            else{
                layout.setBackgroundColor(Color.RED)
                Toast.makeText(this,"Incorrect", Toast.LENGTH_SHORT).show()
            }
        }


        fun assignRandom() {
            val leftNum:Int = (0..10).shuffled().last()
            var rightNum:Int = leftNum
            while(leftNum == rightNum) {
                rightNum = (0..10).shuffled().last()
            }
            leftbutton.text = leftNum.toString()
            rightbutton.text = rightNum.toString()
        }

        assignRandom()
        leftbutton.setOnClickListener {
            checkAnswer(true)
            assignRandom()
        }

        rightbutton.setOnClickListener {
            checkAnswer(false)
            assignRandom()
        }

    }




}