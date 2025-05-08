package com.bit.mobileprogramming

import MyDatabaseHelper
import android.annotation.SuppressLint
import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class FormActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    lateinit var db: MyDatabaseHelper

     @SuppressLint("MissingInflatedId")
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val etName = findViewById<EditText>(R.id.etName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val radioGroupGender = findViewById<RadioGroup>(R.id.radioGroupGender)
        val spinnerCountry = findViewById<Spinner>(R.id.spinnerCountry)
        val checkboxTerms = findViewById<CheckBox>(R.id.checkboxTerms)
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val resultText = findViewById<TextView>(R.id.formRes)

        // Spinner setup
//        val countries = arrayOf("Nepal", "India", "USA", "UK", "Australia")
//        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        spinnerCountry.adapter = adapter

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

         db = MyDatabaseHelper(this)

         btnRegister.setOnClickListener {

//               val name="Ram Limbu"
//               val email = "ram@gmail.com"
             val name = etName.text.toString()
             val email = etEmail.text.toString()
             val genderId = radioGroupGender.checkedRadioButtonId
             val gender = findViewById<RadioButton>(genderId)?.text.toString()
             val country = spinnerCountry.selectedItem.toString()
             val acceptedTerms = checkboxTerms.isChecked

             val success = db.insertUser(name, email, gender, country, acceptedTerms)

             if (success) {
                 Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()

                 val intent = Intent(this, ResultActivity::class.java)
                 startActivity(intent)

             } else {
                 Toast.makeText(this, "Registration Failed", Toast.LENGTH_SHORT).show()
             }
             }
         }


//        btnRegister.setOnClickListener {
//
//            val name = etName.text.toString()
//            val email = etEmail.text.toString()
//            val genderId = radioGroupGender.checkedRadioButtonId
//            val selectedGender = if (genderId != -1) {
//                findViewById<RadioButton>(genderId).text.toString()
//            } else {
//                ""
//            }
//            val country = spinnerCountry.selectedItem.toString()
//            val acceptedTerms = checkboxTerms.isChecked
//
////            resultText.text=name.toString()
//
//
//            if (name.isEmpty() || email.isEmpty() || selectedGender.isEmpty() || !acceptedTerms) {
//                Toast.makeText(this, "Please complete all fields", Toast.LENGTH_SHORT).show()
//            } else {
//
//                val intent = Intent(this,ResultActivity::class.java).apply {
//                    putExtra("name",name)
//                    putExtra("email",email)
//                    putExtra("gender",selectedGender)
//                    putExtra("country",country)
//                }
//                startActivity(intent)
//                overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
//                //val fragment = YourFragment()
//                //supportFragmentManager.beginTransaction()
//                //    .setCustomAnimations(
//                //        R.anim.enter_from_right,  // enter
//                //        R.anim.exit_to_left,      // exit
//                //        R.anim.enter_from_left,   // popEnter
//                //        R.anim.exit_to_right      // popExit
//                //    )
//                //    .replace(R.id.fragment_container, fragment)
//                //    .addToBackStack(null)
//                //    .commit()
//
////            val data = """
////            Name: $name
////            Email: $email
////            Country: $country""".trimIndent()
////
////                resultText.text = data
//
////                val intent = Intent(this, ResultActivity::class.java).apply {
////                    putExtra("name", name)
////                    putExtra("email", email)
////                    putExtra("gender", selectedGender)
////                    putExtra("country", country)
////                }
////                startActivity(intent)
//            }
//        }
//

    }
