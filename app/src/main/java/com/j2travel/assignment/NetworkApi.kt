package com.j2travel.assignment

import com.j2travel.assignment.model.Articles
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkApi {

    @GET("/jet2/api/v1/blogs?page=1&limit=10")
    fun getArticles(): Call<List<Articles>>

    @GET("/jet2/api/v1/blogs")
    fun getArticlesByPageNumber(@Query("page") pageNumber: Int, @Query("limit") limit: Int ): Call<List<Articles>>


}