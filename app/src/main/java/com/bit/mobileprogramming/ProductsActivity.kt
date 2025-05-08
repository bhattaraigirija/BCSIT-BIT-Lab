package com.bit.mobileprogramming

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bit.mobileprogramming.adapter.ProductAdapter
import com.bit.mobileprogramming.model.Product
import com.bit.mobileprogramming.network.RetrofitClient
import com.google.android.material.appbar.MaterialToolbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        // Setup AppBar with back navigation
        val toolbar = findViewById<Toolbar>(R.id.toolbarProduct)
        setSupportActionBar(toolbar)
        supportActionBar?.setTitle("Products")

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getProducts().enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful && response.body() != null) {
                    recyclerView.adapter = ProductAdapter(response.body()!!)
                } else {
                    Toast.makeText(this@ProductsActivity, "No data found!", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Toast.makeText(this@ProductsActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    // Handle back button click
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}