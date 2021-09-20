package com.example.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout
import kotlin.Exception


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn: Button = findViewById(R.id.button)
        val result: TextView = findViewById(R.id.textView)

        btn.setOnClickListener {
                try {
                    var number = findViewById<EditText>(R.id.inputText).text.toString().toInt()
                    result.text =check(number)

                }catch(e:Exception){
                    result.text ="გთხოვთ შეიყვანოთ რიცხვი ციფრებით"
                }
        }
    }
        fun check(number:Int) :String{
            var first = number/100
            var second = number/10%10
            var third = number%10
            var inWords = ""
            //first
            if(first==1){
                inWords +="ას"
            }else if(first == 0){
                inWords += ""
            }else{
                inWords +=digit(first).slice(0..digit(first).length-2)+"ას"
            }
            //   second
            if(second==0 || second ==1){
                inWords +=""
            }else{
                inWords +=digit2(second)
            }
            //third
            inWords +=digit3(second, third)
            if(number==0) inWords = "ნული"
            return inWords
        }
        fun digit( num1 :Int) :String{
            var str :String = ""
            when(num1){
                1 -> str =  "ერთი"
                2 -> str =  "ორი"
                3 -> str =  "სამი"
                4 -> str =  "ოთხი"
                5 -> str =  "ხუთი"
                6 -> str =  "ექვსი"
                7 -> str =  "შვიდი"
                8 -> str =  "რვა"
                9 -> str =  "ცხრა"
            }
            return str
        }
        fun digit2( num1 :Int) :String{
            var str :String = ""
            when(num1){
                2, 3 -> str =  "ოცდა"
                4, 5 -> str =  "ორმოცდა"
                6,7  -> str =  "სამოცდა"
                8, 9 -> str =  "ოთხმოცდა"
            }
            return str
        }
        fun digit3(second :Int, third :Int) :String{
            var str = ""
            if(second%2==0 &&second !=0){
                str = digit(third)
            }else{
                when(third){
                    0 -> str =  if (second%2==0 &&second !=0)"ი" else "ათი"
                    1 -> str =  "თერთმეტი"
                    2 -> str =  "თორმეტი"
                    3 -> str =  "ცამეტი"
                    4 -> str =  "თოთხმეტი"
                    5 -> str =  "თხუთმეტი"
                    6 -> str =  "თექვსმეტი"
                    7 -> str =  "ჩვიდმეტი"
                    8 -> str =  "თვრამეტი"
                    9 -> str =  "ცხრამეტი"
                }

            }
            return str
        }

}