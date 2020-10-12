package com.j2travel.assignment

import android.app.Application
import com.j2travel.assignment.repository.ArticleDataRepository
import com.j2travel.assignment.viewmodel.ArticleViewModel
import org.koin.android.ext.android.startKoin
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class J2TravelApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this,
            listOf(loadModule),
            loadPropertiesFromFile = true)

    }

    val loadModule = module {

        single { ArticleDataRepository(get()) }

        single { getDataFromWebService() }

        viewModel { ArticleViewModel(get()) }

    }

    fun getDataFromWebService(): NetworkApi {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("https://5e99a9b1bc561b0016af3540.mockapi.io")
            .build()

        return retrofit.create(NetworkApi::class.java)
    }

}