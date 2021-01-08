import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.alexpetrik.androidacademyglobalhomework.MovieAPIService
import ru.alexpetrik.androidacademyglobalhomework.baseURL

@ExperimentalSerializationApi
object RetrofitModule {

    private val json = Json {
        ignoreUnknownKeys = true
    }

    private val okHttpClient = OkHttpClient.Builder()
        .build()

    private val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(baseURL)
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    val movieAPI: MovieAPIService = retrofit.create(MovieAPIService::class.java)

}