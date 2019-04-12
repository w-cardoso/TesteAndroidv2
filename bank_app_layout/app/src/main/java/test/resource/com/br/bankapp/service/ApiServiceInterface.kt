package test.resource.com.br.bankapp.service

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import test.resource.com.br.bankapp.util.Constants
import test.resource.com.br.bankapp.model.Login
import test.resource.com.br.bankapp.model.LoginResponse
import retrofit2.http.POST
import retrofit2.http.GET
import retrofit2.http.Path
import test.resource.com.br.bankapp.model.ListStatementResponse


interface ApiServiceInterface {

    @POST("login")
    fun login(@Body login: Login): Call<LoginResponse>

    @GET("statements/{id}")
    fun getMovies(@Path("id") id: Int): Observable<ListStatementResponse>

    companion object Factory {
        fun create(): ApiServiceInterface {
            val retrofit = retrofit2.Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(Constants.BASE_URL)
                    .build()

            return retrofit.create(ApiServiceInterface::class.java)
        }
    }
}