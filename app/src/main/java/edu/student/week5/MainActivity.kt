package edu.student.week5

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var txtName = findViewById<EditText>(R.id.txtName)
        var txtEmail = findViewById<EditText>(R.id.txtEmail)
        var txtShow = findViewById<TextView>(R.id.txtShow)
        var rbFemale = findViewById<RadioButton>(R.id.rbFemale)
        var rbMale = findViewById<RadioButton>(R.id.rbMale)
        var btnSubmit = findViewById<Button>(R.id.btnSubmit)

        txtName.requestFocus()


        btnSubmit.setOnClickListener {

            if (txtName.text.toString() == "" || txtEmail.text.toString() == "") {
                if (txtName.text.toString() == "") {
                    Toast.makeText(this, "Enter in Name", Toast.LENGTH_LONG).show()
                    hideKeyboard()
                    txtShow.text = ""
                    txtName.requestFocus()
                } else {
                    Toast.makeText(this, "Enter in Email", Toast.LENGTH_LONG).show()
                    hideKeyboard()
                    txtShow.text = ""
                    txtEmail.requestFocus()
                }
            } else {
                if ((rbFemale.isChecked) || (rbMale.isChecked)){
                    if (rbFemale.isChecked) txtShow.text =
                        "Hello, ${txtName.text}, the women's lounge is on first floor. We will " +
                                "send an email of meeting agenda to email : ${txtEmail.text}."

                    if (rbMale.isChecked) txtShow.text =
                        "Hello, ${txtName.text}, the men's lounge is on the second floor. We will " +
                                "send an email of meeting agenda to email : ${txtEmail.text}."
                    hideKeyboard()
                    txtName.setText("")
                    txtEmail.setText("")
                    txtName.requestFocus()
                }
                else {
                    Toast.makeText(this, "Select a gender", Toast.LENGTH_LONG).show()
                    hideKeyboard()
                }
            }
        }

        findViewById<View>(android.R.id.content).setOnTouchListener { _, event ->
            hideKeyboard()
            false
        }
    }

        fun hideKeyboard() {
            try {
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
            } catch (e: Exception) {
                // TODO: handle exception
            }

        }

}
