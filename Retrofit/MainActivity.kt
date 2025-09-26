package com.example.retrofit

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import support.RetrofitInterface
import okhttp3.ResponseBody
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import support.Retrofit2
import java.net.SocketTimeoutException
import kotlin.jvm.java





class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        SchoolListWithName()
    }

    fun SchoolListWithName() {
        var pd: ProgressDialog? = null
        pd = ProgressDialog(this@MainActivity)
        pd.setCancelable(false)
        pd.setMessage("Please wait a moment")
        pd.setCanceledOnTouchOutside(false)
        pd.show()
        var Schoolid: String
        var Name: String
        var remoteResponse: String? = null
        val retrofit = Retrofit.Builder()
            .baseUrl(Keys.testURL)
            .client(Retrofit2.getUnsafeOkHttpClient().build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val retrofitInterface = retrofit.create(
            RetrofitInterface::class.java
        )
        val call = retrofitInterface.SchoolListWithName()
        call!!.enqueue(object : Callback<ResponseBody?> {

            override fun onResponse(call: Call<ResponseBody?>, response: Response<ResponseBody?>) {
                Log.v(Keys.KEY_TAG, "-----response--------$response")
                Log.v(Keys.KEY_TAG, "-----response-code--------" + response.code())
                Log.v(Keys.KEY_TAG, "-----response-body-----" + response.body())
                remoteResponse = response?.body()?.string()
                if (response.code() == 200) {
                    try {
                        val jsonarray = JSONArray(remoteResponse)
                        for (i in 0 until jsonarray.length()) {
                            val c = jsonarray.getJSONObject(i)
                            val title = c.getString("Name")
                            var sid = c.getString("Schoolid")
                            val statusopen = c.getString("isopen")
                            Schoolid = c.getString("Schoolid")
                            Name = c.getString("Name")
                            Log.v(Keys.KEY_TAG, "--Schoolid-----= $Schoolid")
                            Log.v(Keys.KEY_TAG, "--Username------$Name")
                            Log.v(Keys.KEY_TAG, "--isopen------$statusopen")

                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }


                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "School ID and School Name Not Available",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                    Log.v(Keys.KEY_TAG, "--errorBody--- " + response.errorBody())
                    Log.v(Keys.KEY_TAG, "-----response-code--error------" + response.code())

                }
                pd.dismiss()
            }

            override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
                if (t is SocketTimeoutException) {
                    val message = "Poor network connection. Please try again."
                    Log.e(Keys.KEY_TAG, message)
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Internet Connection Error Try After Some Time",
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.e(Keys.KEY_TAG, "onFailure: " + t.localizedMessage)
                }
                pd.dismiss()
                Log.v(Keys.KEY_TAG, "--outside--runCatching----")
            }

        })


    }

}