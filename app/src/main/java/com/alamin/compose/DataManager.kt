package com.alamin.compose

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.alamin.compose.model.Quote
import com.google.gson.Gson
import java.util.ArrayList

object DataManager {

    var data = emptyArray<Quote>()

    var isLoaded = mutableStateOf(false)

    fun loadAssetData(context: Context){

        val inputStream = context.assets.open("quotes.json")
        val size:Int = inputStream.available()
        val buffer = ByteArray(size)

        inputStream.read(buffer)
        inputStream.close()

        val json = String(buffer,Charsets.UTF_8)

        data = Gson().fromJson(json,Array<Quote>::class.java)

        isLoaded.value = true

    }

}