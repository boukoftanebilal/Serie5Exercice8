package com.example.serie5exercice8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.RemoteCallbackList
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var textViewResult : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var retrofit : Retrofit
        retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create()).build()

        var jsonPlaceHolderApi : JsonPlaceHolderApi
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi::class.java)


        var call: Call<List<Post>> = jsonPlaceHolderApi.getPosts()
        call.enqueue(object : Callback<List<Post>>{
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {

                if (!response.isSuccessful){
                    textViewResult.setText("code :" + response.code())
                    return
                }
                var posts : List<Post>
                posts = response.body()!!

                for (post : Post in posts){
                    var cntent: String =""
                    cntent += "ID: " + post.getid() + "\n"
                    cntent += "ID: " + post.getuserId() + "\n"
                    cntent += "ID: " + post.gettitle() + "\n"
                    cntent += "ID: " + post.gettext() + "\n"
                    textViewResult.append(cntent)

                }

            }
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                textViewResult.setText(t.message)
            }
        })

    }
}
