package com.bit.mobileprogramming

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bit.mobileprogramming.adapter.PersonAdapter
import com.bit.mobileprogramming.model.Person

class TasksActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PersonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks)

        val personList = listOf(
            Person("Ram Limbu", "123 Main Street","9812123423","www.google.com"),
            Person("Hari Smith", "456 Oak Avenue","9878765456","www.facebook.com"),
            Person("Alex Bhandari", "789 Pine Road","9876789876","wwww.youtube.com")
        )

        // Set toolbar as action bar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Show back button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Person List"

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)



        val adapter = PersonAdapter(this, personList)
        recyclerView.adapter = adapter


    }

    // Handle back button click
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}
