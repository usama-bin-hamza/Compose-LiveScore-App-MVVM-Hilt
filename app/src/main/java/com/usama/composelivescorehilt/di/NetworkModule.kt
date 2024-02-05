package com.usama.composelivescorehilt.di

import com.usama.composelivescorehilt.data.remote.ElenaApiService
import com.usama.composelivescorehilt.util.BASE_URL
import com.usama.composelivescorehilt.util.RequestInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
//    @Singleton
    @Provides
    fun okHttp(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(RequestInterceptor())
            .build()
    }

    @Singleton
    @Provides
    fun retrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

//    @Singleton
    @Provides
    fun elenaApiService(retrofit: Retrofit): ElenaApiService {
        return retrofit.create(ElenaApiService::class.java)
    }
}