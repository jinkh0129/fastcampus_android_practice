package com.example.bmi_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height:Float? = intent.getStringExtra("height")?.toFloat()
        val weight:Float? = intent.getStringExtra("weight")?.toFloat()

        val bmi = weight!! /Math.pow(height!! /100.0,2.0)

        when{
            bmi>=35 -> resultTextView.text = "고도비만"
            bmi>=30 -> resultTextView.text = "2단계 비만"
            bmi>=25 -> resultTextView.text = "1단계 비만"
            bmi>=23 -> resultTextView.text = "과체중"
            bmi>=18.5 -> resultTextView.text = "정상체중"
            else -> resultTextView.text = "저체중"
        }

        when{
            bmi >= 23 ->
                imageView.setImageResource(
                    R.drawable.anchovy
                )
            bmi >= 18.5 ->
                imageView.setImageResource(
                    R.drawable.bear
                )
            else ->
                imageView.setImageResource(
                    R.drawable.inca
                )

        }

        Toast.makeText(this,"$bmi",Toast.LENGTH_SHORT).show()

    }
}