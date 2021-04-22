package ru.alexpetrik.androidacademyglobalhomework.net

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import ru.alexpetrik.androidacademyglobalhomework.apiKey
import ru.alexpetrik.androidacademyglobalhomework.baseURL

@ExperimentalSerializationApi
object RetrofitModule {

    private val json = Json {
        ignoreUnknownKeys = true
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(MovieApiInterceptor())
        .build()

    private val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(baseURL)
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    val movieAPI: MovieAPIService = retrofit.create(MovieAPIService::class.java)

    class MovieApiInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val originRequest = chain.request()
            val originUrl = originRequest.url

            val url = originUrl.newBuilder()
                .addQueryParameter(
                    name = "api_key",
                    value = apiKey
                )
                .addQueryParameter(
                    name = "language",
                    value = "en-US"
                )
                .build()

            val request = originRequest.newBuilder()
                .url(url = url)
                .build()

            return chain.proceed(request)
        }
    }
}