package com.bit.mobileprogramming.network
import com.bit.mobileprogramming.model.Product
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    fun getProducts(): retrofit2.Call<List<Product>>

}
