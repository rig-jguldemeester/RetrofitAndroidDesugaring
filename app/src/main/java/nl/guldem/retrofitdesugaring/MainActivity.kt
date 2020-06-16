package nl.guldem.retrofitdesugaring

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.time.Instant

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
           CoroutineScope(Dispatchers.IO).launch {
                getRetrofitClient().queryInstant(Instant.now())
                withContext(Dispatchers.Main){
                    text_result.text = "request fired"
                }

            }

        }
    }

    private fun getRetrofitClient(): ApiService {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://www.google.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(ApiService::class.java)
    }


}


interface ApiService {

    @GET("search")
    suspend fun queryInstant(@Query("q") dateTime: Instant): ResponseBody
}