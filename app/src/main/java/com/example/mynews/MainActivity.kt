package com.example.mynews

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mynews.modelclasses.Source
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
      var newsInterface: NewsInterface? = null
    lateinit var newsAdapter: NewsAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val retrofit:Retrofit = Retrofit.Builder()
            .baseUrl("https://newsdata.io/api/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        newsInterface = retrofit.create(NewsInterface::class.java)
        getRequest(recyclerView)
    }

    fun getRequest(view: View) {
        val apikey = "pub_58023fea33dd9c23d32363e38f6fda41c20c4"
        val country = "us"
        val category = "technology"
        val language = "en"
        newsInterface?.getNews(apikey, country, language, category)?.enqueue(object : Callback<Source> {
            override fun onResponse(p0: Call<Source>, p1: Response<Source>) {
                if (p1.isSuccessful && p1.body() != null) {
                    val newsList = p1.body()?.results?: emptyList()
                    newsAdapter = NewsAdapter(newsList)
                    recyclerView.adapter = newsAdapter
                    }
            }
            override fun onFailure(p0: Call<Source>, p1: Throwable) {
                TODO("Not yet implemented")
            }
        } )
        }
}