package com.alamin.compose.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alamin.compose.R
import com.alamin.compose.model.Quote

@Composable
fun QuotesListScreen(data: Array<Quote>, onClick: (quote:Quote) -> Unit) {

    Column {
        Text(
            text = "Quotes App",
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontFamily = FontFamily(Font(R.font.lobster_regular)), modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)
        )

        QuotesList(quotes = data) {
            quote: Quote -> onClick(quote)
        }

    }

}