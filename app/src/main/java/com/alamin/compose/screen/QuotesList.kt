package com.alamin.compose.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.alamin.compose.model.Quote

@Composable
fun QuotesList(quotes: Array<Quote>,onClick: ()->  Unit) {

    LazyColumn(){
        items(quotes){ it ->
            QuotesListItem(it){ onClick() }
        }
    }

}