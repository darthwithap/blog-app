package me.darthwithap.api

import me.darthwithap.api.client.ConduitApi
import me.darthwithap.api.client.ConduitAuthApi
import okhttp3.Interceptor
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.internal.http2.Header
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    private var _authToken: String? = null
    private val okhttpInterceptor = Interceptor { chain ->
        var req = chain.request()
        _authToken?.let {
            req = req.newBuilder()
                .header("Authorization", "Token $it")
                .build()
        }
        chain.proceed(req)
    }

    val authToken get() = _authToken

    fun setAuthToken(token: String?) {
        _authToken = token
    }

    private val okhttp = OkHttpClient.Builder()
        .connectTimeout(2, TimeUnit.SECONDS)
        .readTimeout(5, TimeUnit.SECONDS)

    private val retrofitBuilder = Retrofit.Builder()
        .baseUrl("https://conduit.productionready.io/api/")
        .addConverterFactory(MoshiConverterFactory.create())

    val api = retrofitBuilder
        .client(okhttp.build())
        .build()
        .create(ConduitApi::class.java)

    val authApi = retrofitBuilder
        .client(okhttp.addInterceptor(okhttpInterceptor).build())
        .build()
        .create(ConduitAuthApi::class.java)
}