package com.manuelapk.pelis.core

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.manuelapk.pelis.data.network.api.MovieApi
import com.manuelapk.pelis.presenter.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(@Named("auth_client") client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.TMDB_BASE_URL)
            .client(client)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    @Singleton
    @Provides
    @Named("auth_client")
    fun provideAuthClient(): OkHttpClient {
        val headerInterceptor = Interceptor { chain ->
            val request = chain.request().newBuilder()
                //.addHeader("Authorization", "Bearer ${Constants.API_KEY}")
                .build()
            chain.proceed(request)
        }
        return OkHttpClient.Builder()
            .addInterceptor(headerInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieApi(retrofit: Retrofit): MovieApi {
        return retrofit.create(MovieApi::class.java)
    }


}