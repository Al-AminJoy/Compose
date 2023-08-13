package com.alamin.compose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.text.style.TextAlign
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


    private var currentQuote:Quote? = null


    @Composable
    fun App() {

        var counter = remember {
            mutableStateOf(0)
        }
        
        var showEffect = counter.value % 4 == 0
        
        LaunchedEffect(key1 = showEffect){
            Log.d(TAG, "App: $showEffect ${counter.value}")
        }
        
        Button(onClick = { 
            counter.value++
        }) {
            Text(text = "Click")
        }

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






}