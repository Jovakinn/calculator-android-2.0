package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_0.setOnClickListener{setTextFields("0")}
        btn_1.setOnClickListener{setTextFields("1")}
        btn_2.setOnClickListener{setTextFields("2")}
        btn_3.setOnClickListener{setTextFields("3")}
        btn_4.setOnClickListener{setTextFields("4")}
        btn_5.setOnClickListener{setTextFields("5")}
        btn_6.setOnClickListener{setTextFields("6")}
        btn_7.setOnClickListener{setTextFields("7")}
        btn_8.setOnClickListener{setTextFields("8")}
        btn_9.setOnClickListener{setTextFields("9")}
        substract_btn.setOnClickListener{setTextFields("-")}
        sum_btn.setOnClickListener{setTextFields("+")}
        multiply_btn.setOnClickListener{setTextFields("*")}
        divide_btn.setOnClickListener{setTextFields("/")}
        left_side_bracket_btn.setOnClickListener{setTextFields("(")}
        right_side_bracket_btn.setOnClickListener{setTextFields(")")}

        ac_btn.setOnClickListener{
            mathOperation.text = ""
            resultText.text = ""
        }

        back_btn.setOnClickListener{
            val str = mathOperation.text.toString()
            if(str.isNotEmpty())
                mathOperation.text = str.substring(0, str.length-1)

            resultText.text = ""
        }

        equal_btn.setOnClickListener{
            try {
                val ex = ExpressionBuilder(mathOperation.text.toString()).build()
                val result = ex.evaluate()
                val longRes = result.toLong()

                if (result == longRes.toDouble())
                    resultText.text = longRes.toString()
                 else
                    resultText.text = result.toString()

            } catch (e: Exception) {
                Log.d("Error", "Message: ${e.message}")
            }
        }
    }
    fun setTextFields(str: String) {
        if (resultText.text != "")
            mathOperation.text = resultText.text
            resultText.text = ""

        mathOperation.append(str)
    }
}
