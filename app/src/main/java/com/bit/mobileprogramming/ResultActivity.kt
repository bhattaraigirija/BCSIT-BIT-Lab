package com.bit.mobileprogramming

import MyDatabaseHelper
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    lateinit var db: MyDatabaseHelper
    lateinit var listViewResults: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        listViewResults = findViewById(R.id.listViewResults)
        db = MyDatabaseHelper(this)


        // Fetch data from DB
        val userList = mutableListOf<String>()
        val cursor = db.getAllUsers()

        if (cursor.moveToFirst()) {
            do {
                val name = cursor.getString(1)
                val email = cursor.getString(2)
                val gender = cursor.getString(3)
                val country = cursor.getString(4)
                val terms = if (cursor.getInt(5) == 1) "Yes" else "No"

                userList.add(
                    "Name: $name\nEmail: $email\nGender: $gender\nCountry: $country\nTerms: $terms"
                )
            } while (cursor.moveToNext())
        }

        cursor.close()

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, userList)
        listViewResults.adapter = adapter
    }
}