package com.alamin.compose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pending
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate

import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.loader.content.Loader
import com.alamin.compose.model.Quote

import com.alamin.compose.screen.QuotesDetails
import com.alamin.compose.screen.QuotesListScreen
import com.alamin.compose.ui.theme.ComposeTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.log

private const val TAG = "CheezyActivity"

class CheezyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CoroutineScope(IO).launch {
            delay(1000)
            DataManager.loadAssetData(applicationContext)
        }

        setContent {
            ComposeTheme {
                App()
            }
        }
    }


    private var currentQuote: Quote? = null


    @Composable
    fun App() {

        Loader()

        /*if (Navigation.currentState.value == PAGE.QUOTES_LIST){
            if (DataManager.isLoaded.value){
                QuotesListScreen(data = DataManager.data) {  quote ->
                    currentQuote = quote
                    Navigation.navigatePage(PAGE.QUOTES_DETAILS)
                }
            }else{
                Box(modifier = Modifier.fillMaxSize(1f),
                    contentAlignment = Alignment.Center) {
                    Text(text = "Loading...", textAlign = TextAlign.Center)
                }
            }
        }else{

            currentQuote?.let {
                QuotesDetails(quote = it)
            }


        }*/


    }

    @Composable
    fun Loader() {

        val degree = produceState(initialValue = 0) {
            while (true) {
                delay(10)
                Log.d(TAG, "Loader: ${(value + 10) % 360}")
                value = (value + 10) % 360
            }
        }



        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize(1f)) {
            Column {
                Image(
                    imageVector = Icons.Filled.Refresh,
                    contentDescription = null,
                    modifier = Modifier
                        .size(60.dp)
                        .rotate(degree.value.toFloat())
                )
                Text(text = "Loading")

            }
        }
    }


}