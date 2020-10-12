package com.j2travel.assignment.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.j2travel.assignment.model.Articles
import com.j2travel.assignment.repository.ArticleDataRepository
import org.koin.standalone.KoinComponent

class ArticleViewModel(val articleDataRepository: ArticleDataRepository ) : ViewModel(), KoinComponent {

    var articleList = MutableLiveData<List<Articles>>()

    init {
        articleList.value = listOf()
    }

    fun getArticles() {
        articleDataRepository.getArticles(object : ArticleDataRepository.ArticleData {
            override fun onSuccess(data: List<Articles>) {
                articleList.value = data
            }

            override fun onFailure() {
                Log.e("ArticleViewModel", "onFailure")
            }
        })
    }

    fun getArticlesByPage(page : Int, limit : Int ){

        articleDataRepository.getArticlesByPage(page, limit, object : ArticleDataRepository.ArticleData{
            override fun onSuccess(data: List<Articles>) {
                articleList.value = data
            }

            override fun onFailure() {
                Log.e("ArticleViewModel", "onFailure")
            }


        })

    }

}