package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {
    
    var tripList = arrayListOf<Trip>(
        Trip("63빌딩", "30", "28", "4.2"),
        Trip("타임스퀘어", "70", "39", "4.3")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tripAdapter = TripListView(this, tripList)
        mListView.adapter = tripAdapter

        // 데이터 요청하기
//        thread(start=true) {
//            try {
//                var urlText = "http://10.0.2.2:8080/api/travels/listByInsideAndFieldNo/1"
//
//                val url = URL(urlText)
//
//                val urlConnection = url.openConnection() as HttpURLConnection
//                urlConnection.requestMethod = "GET"
//
//                val content = StringBuilder()
//
//                if (urlConnection.responseCode == HttpURLConnection.HTTP_OK) {
//                    val streamReader = InputStreamReader(urlConnection.inputStream)
//                    val buffered = BufferedReader(streamReader)
//
//                    while (true) {
//                        val line = buffered.readLine() ?: break
//                        content.append(line)
//                    }
//
//                    buffered.close()
//                }
//
//                urlConnection.disconnect()
//
//                runOnUiThread {
//                    Log.d("log", content.toString())
//                }
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//
//        }
    }
}