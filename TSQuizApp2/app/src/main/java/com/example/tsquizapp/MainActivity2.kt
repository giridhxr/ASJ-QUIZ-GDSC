package com.example.tsquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import kotlin.collections.ArrayList

class MainActivity2 : AppCompatActivity() {
    private lateinit var pointText: TextView
    private lateinit var questionNoText: TextView
    private lateinit var questionText: TextView
    private lateinit var optionAText: RadioButton
    private lateinit var optionBText: RadioButton
    private lateinit var optionCText: RadioButton
    private lateinit var optionDText: RadioButton
    private lateinit var submitButton: Button

    private lateinit var questionBank : ArrayList<Question>
    private var questionNo : Int = 0
    private var answer : String = ""
    private var score : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        pointText = findViewById(R.id.textView4)
        questionNoText = findViewById(R.id.textView)
        questionText = findViewById(R.id.textView3)
        optionAText = findViewById(R.id.radioButton)
        optionBText = findViewById(R.id.radioButton2)
        optionCText = findViewById(R.id.radioButton3)
        optionDText = findViewById(R.id.radioButton4)

        submitButton = findViewById(R.id.button2)

        questionBank = ArrayList()
        questionNo = 0

        setupQuestion()
        initListener()

        display(questionNo);


    }

    fun clearAll() {
        optionAText.isChecked = false
        optionBText.isChecked = false
        optionCText.isChecked = false
        optionDText.isChecked = false
    }
    fun display(index : Int){
        var questionObject = questionBank.get(index)
        questionNoText.text = "Question No."+ (questionNo + 1).toString()
        questionNoText.text = questionObject.question
        optionAText.text = questionObject.optionA
        optionBText.text = questionObject.optionB
        optionCText.text = questionObject.optionC
        optionDText.text = questionObject.optionD
    }
    fun setupQuestion(){
        questionBank.add(
            Question(
                "What was the first single released from the album?",
                "Style",
                "Blank Space",
                "Out of the woods",
                "shake it off",
                "shake it off"
            )
        )
        questionBank.add(
            Question(
                "Which of these songs was never made into a music video?",
                "Style",
                "Wildest dreams",
                "Clean",
                "New Romantics",
                "Clean"
            )
        )
        questionBank.add(
            Question(
                "How many grammy nominations did taylor receive for 1989?",
                "5",
                "6",
                "7",
                "8",
                "7"
            )
        )
        questionBank.add(
            Question(
                "Which of these songs is not a bonus track from 1989?",
                "I Know Places",
                "Wonderland",
                "New Romantics",
                "You are in Love",
                "I Know Places"
            )
        )
        questionBank.add(
            Question(
                "How Many Copies did the album sell in its first week?",
                "1,000,000",
                "1,120,000",
                "1,280,000",
                "1,560,000",
                "1,280,000"
            )
        )

    }
    fun isCorrect(value : String) : Boolean{
        return answer == value
    }
    fun initListener(){
        optionAText.setOnClickListener {
            clearAll()
            optionAText.isChecked = true
            answer = optionAText.text.toString()

        }

        optionBText.setOnClickListener {
            clearAll()
            optionBText.isChecked = true
            answer = optionBText.text.toString()

        }

        optionCText.setOnClickListener {
            clearAll()
            optionCText.isChecked = true
            answer = optionCText.text.toString()

        }

        optionDText.setOnClickListener {
            clearAll()
            optionDText.isChecked = true
            answer = optionDText.text.toString()
        }

        submitButton.setOnClickListener {
            clearAll()
            if(isCorrect(questionBank.get(questionNo).answer)) {
                score = score + 10;
                pointText.text = "Points: " + score.toString()
            }
            if(questionNo < (questionBank.size - 1)) {
                questionNo++
                display(questionNo)
            } else {
                //go to final page
                var intent = Intent(this, MainActivity3::class.java)
                intent.putExtra("score" , score.toString())
                startActivity(intent)
            }

        }
    }
}

 data class Question(
   var question : String ,
   var optionA : String ,
   var optionB : String ,
   var optionC : String ,
   var optionD : String ,
   var answer : String ,

)