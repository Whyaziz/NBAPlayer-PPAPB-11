package com.android.nbaplay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.android.nbaplay.databinding.ActivityMainBinding
import com.android.nbaplay.model.ApiResponse
import com.android.nbaplay.model.NbaPlayer
import com.android.nbaplay.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listView = binding.listView

        fetchData()
    }

    private fun fetchData() {
        val apiService = ApiClient.getInstance().getPlayerData()

        apiService.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    val nbaPlayerList: List<NbaPlayer>? = response.body()?.data
                    if (nbaPlayerList != null) {
                        val adapter = PlayerAdapter(this@MainActivity, nbaPlayerList)
                        listView.adapter = adapter
                    }
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}