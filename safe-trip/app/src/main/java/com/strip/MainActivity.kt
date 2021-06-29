package com.strip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val urlRequest = findViewById<Button>(R.id.urlRequest)
        val tv = findViewById<TextView>(R.id.tv_1)

        urlRequest.setOnClickListener {
            thread(start=true) {
                try {
                    var urlText = "http://10.0.2.2:8080/api/travels/listByInsideAndFieldNo/1"

                    val url = URL(urlText)

                    val urlConnection = url.openConnection() as HttpURLConnection
                    urlConnection.requestMethod = "GET"

                    val content = StringBuilder()

                    if (urlConnection.responseCode == HttpURLConnection.HTTP_OK) {
                        val streamReader = InputStreamReader(urlConnection.inputStream)
                        val buffered = BufferedReader(streamReader)

                        while (true) {
                            val line = buffered.readLine() ?: break
                            content.append(line)
                        }

                        buffered.close()
                    }

                    urlConnection.disconnect()

                    runOnUiThread {
                        tv.text = content.toString()
                        Log.d("log", content.toString())
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
}