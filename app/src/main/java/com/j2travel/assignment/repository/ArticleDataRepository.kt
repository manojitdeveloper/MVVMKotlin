package com.j2travel.assignment.repository

import com.j2travel.assignment.NetworkApi
import com.j2travel.assignment.model.Articles
import retrofit2.Call
import retrofit2.Response

class ArticleDataRepository(val netWorkApi: NetworkApi) {

    fun getArticles(articleData: ArticleData) {
        netWorkApi.getArticles().enqueue(object : retrofit2.Callback<List<Articles>> {
            override fun onResponse(call: Call<List<Articles>>, response: Response<List<Articles>>) {
                articleData.onSuccess((response.body() as List<Articles>))
            }

            override fun onFailure(call: Call<List<Articles>>, t: Throwable) {
                articleData.onFailure()
            }
        })
    }

    fun getArticlesByPage(pageNumber: Int, limit: Int, articleData: ArticleData){
        netWorkApi.getArticlesByPageNumber(pageNumber, limit).enqueue(object : retrofit2.Callback<List<Articles>>{
            override fun onFailure(call: Call<List<Articles>>, t: Throwable) {
                articleData.onFailure()
            }

            override fun onResponse(
                call: Call<List<Articles>>,
                response: Response<List<Articles>>
            ) {
                articleData.onSuccess((response.body() as List<Articles>))
            }

        })

    }

    interface ArticleData {
        fun onSuccess(data: List<Articles>)
        fun onFailure()
    }

}