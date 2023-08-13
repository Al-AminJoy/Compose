package com.alamin.compose

import androidx.compose.runtime.mutableStateOf

object Navigation {

    var currentState = mutableStateOf(PAGE.QUOTES_LIST)


    fun navigatePage(navigate : PAGE) {
        currentState.value = navigate
    }

}

enum class PAGE{
    QUOTES_LIST,QUOTES_DETAILS
}