package com.stavros.bettingdemoapp.httpRequests

import android.os.AsyncTask
import com.google.gson.Gson
import com.stavros.bettingdemoapp.models.GameModel
import com.stavros.bettingdemoapp.models.UpdatedHeadLineModel
import okhttp3.*
import java.io.IOException

class UpdatedHeadLineHttpRequest : AsyncTask<Void, Void, Void>() {
    override fun doInBackground(vararg voids: Void): Void? {
        val url = " http://www.mocky.io/v2/5d711461330000d135779748"


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


                var responseGsonArray = gson.fromJson(returnedBody, Array<UpdatedHeadLineModel>::class.java)
                println(responseGsonArray[0].betViews[0].competitor1Caption)
                println(responseGsonArray[0].betViews[0].competitor2Caption)
                println(responseGsonArray[0].betViews[0].startTime)
            }

            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
            }
        })
        return null
    }
}

