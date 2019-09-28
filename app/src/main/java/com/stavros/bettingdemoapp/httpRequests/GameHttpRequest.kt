package com.stavros.bettingdemoapp.httpRequests

import android.os.AsyncTask
import com.stavros.bettingdemoapp.models.GameModel
import okhttp3.*
import java.io.IOException
import com.google.gson.Gson


class GameHttpRequest : AsyncTask<Void, Void, Void>() {
    override fun doInBackground(vararg voids: Void): Void? {
        val url = "http://www.mocky.io/v2/5d7113513300000b2177973a"


        val request = Request.Builder()
            .addHeader("Content-Type","application/json")
            .url(url)
            .get()
            .build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                var returnedBody = response.body()?.string()
                val gson = Gson()

                
                var responseGsonArray = gson.fromJson(returnedBody, Array<GameModel>::class.java)
                println(responseGsonArray[0].betViews[0].competitions[0].events[0].additionalCaptions.competitor1)
                println(responseGsonArray[0].betViews[0].competitions[0].events[0].additionalCaptions.competitor2)
                println(responseGsonArray[0].betViews[0].competitions[0].events[0].liveData.elapsed)
            }

            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
            }
        })
        return null
    }
}

