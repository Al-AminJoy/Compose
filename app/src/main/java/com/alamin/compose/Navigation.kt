package com.alamin.compose

import androidx.compose.runtime.mutableStateOf

object Navigation {

    var currentState = mutableStateOf(CheezyActivity.PAGE.QUOTES_LIST)


    fun navigatePage(navigate : CheezyActivity.PAGE) {
        currentState.value = navigate
    }

}