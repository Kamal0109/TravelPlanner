package com.example.voyagevue.Activities.Activities.Activities

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.voyagevue.R
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONException
import org.json.JSONObject

class FlightActivity : AppCompatActivity() {

    private lateinit var airportNameTextView: TextView
    private lateinit var airportCodeTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flight)


        airportNameTextView = findViewById(R.id.airport_name)
        airportCodeTextView = findViewById(R.id.airport_code)

        val apiUrl = "https://example.com/api/airport-info"
    }

    inner class FetchAirportInfoTask : AsyncTask<String, Void, String>() {
        override fun doInBackground(vararg urls: String): String? {
            try {
                val client = OkHttpClient()
                val request = Request.Builder()
                    .url(urls[0])
                    .build()

                val response: Response = client.newCall(request).execute()
                return response.body?.string()
            } catch (e: Exception) {
                e.printStackTrace()
                return null
            }
        }

        override fun onPostExecute(result: String?) {
            if (result != null) {
                try {
                    val json = JSONObject(result)
                    val airport = json.getJSONObject("airport")

                    // Access data from the JSON response
                    val airportName = airport.getJSONObject("pluginData").getJSONObject("details").getString("name")
                    val airportIataCode = airport.getJSONObject("pluginData").getJSONObject("details")
                        .getJSONObject("code").getString("iata")

                    // Update your UI with the retrieved data
                    airportNameTextView.text = "Airport Name: $airportName"
                    airportCodeTextView.text = "IATA Code: $airportIataCode"
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            } else {
                // Handle the case where the API request failed
            }
        }
    }
}