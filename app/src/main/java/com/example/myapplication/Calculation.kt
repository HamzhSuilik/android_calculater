package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.annotation.IntegerRes

class Calculation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculation)



        val btn = findViewById<Button>(R.id.sendBtn)
        val edittxt_no1 = findViewById<EditText>(R.id.no1)
        val edittxt_no2 = findViewById<EditText>(R.id.no2)
        val edittxt_no3 = findViewById<EditText>(R.id.no3)
        val spinner = findViewById<Spinner>(R.id.spinner)

        val operations = resources.getStringArray(R.array.operations)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, operations)
        spinner.adapter = adapter




        btn.setOnClickListener{
            var no1 = edittxt_no1.text.toString()
            var no2 = edittxt_no2.text.toString()
            var no3 = edittxt_no3.text.toString()


            if (no1 == "" || no2 == ""  || no3 == ""){
                show_tost("Fill all boxes")
            }else{
                var num1 = no1.toDouble()
                var num2 = no2.toDouble()
                var num3 = no3.toDouble()
                var result = 0.0


                if (spinner.selectedItem.toString() == "Summation +"){
                    result = num1 + num2 + num3
                }else{
                    result = num1 * num2 * num3
                }

                val intent = Intent(this,Result::class.java)
                intent.putExtra("num1","$num1")
                intent.putExtra("num2","$num2")
                intent.putExtra("num3","$num3")
                intent.putExtra("result","$result")
                startActivity(intent)

            }

        }


    }

    fun show_tost(massage:String){
        Toast.makeText(this,massage, Toast.LENGTH_SHORT).show()
    }
}
