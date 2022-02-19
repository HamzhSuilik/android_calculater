package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.loginBtn)
        val user_edit_text = findViewById<EditText>(R.id.editTextUsername)
        val pass_edit_text = findViewById<EditText>(R.id.editTextPassword)

        btn.setOnClickListener{
            var username = user_edit_text.text.toString()
            var password = pass_edit_text.text.toString()

            if (username == "admin" && password == "aaa123"){
                val intent = Intent(this,Calculation::class.java)
                startActivity(intent)
            }else{
                user_edit_text.setText("")
                pass_edit_text.setText("")
                show_tost("Username and password do not match !!")
                user_edit_text.requestFocus()
                val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
            }
        }
    }

    fun show_tost(massage:String){
        Toast.makeText(this,massage,Toast.LENGTH_SHORT).show()
    }
}
