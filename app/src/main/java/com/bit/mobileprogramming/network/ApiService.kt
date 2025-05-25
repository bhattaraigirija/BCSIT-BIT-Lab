package com.bit.mobileprogramming.network
import com.bit.mobileprogramming.model.Product
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("products")
    fun getProducts(): Call<List<Product>>

    @POST("products")
    fun postProduct(@Body product: Product): Call<Product>

}
