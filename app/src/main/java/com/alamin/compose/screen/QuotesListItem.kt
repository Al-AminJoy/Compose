package com.alamin.compose.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alamin.compose.R
import com.alamin.compose.model.Quote

@Composable
fun QuotesListItem(quote: Quote,onClick : () -> Unit) {
    Card(elevation = CardDefaults.cardElevation(4.dp), modifier = Modifier.padding(4.dp).clickable { onClick() }) {

        Row(modifier = Modifier.padding(4.dp)) {

            Image(
                imageVector = Icons.Filled.FormatQuote,
                colorFilter = ColorFilter.tint(color = Color.White),
                alignment = Alignment.Center,
                modifier = Modifier
                    .padding(4.dp)
                    .size(40.dp)
                    .rotate(180f)
                    .background(Color.Black),
                contentDescription = null
            )

            Spacer(modifier = Modifier.size(10.dp))

            Column(modifier = Modifier.weight(1f)) {

                Text(
                    text = "${quote.text}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black
                )
                Box(
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .fillMaxWidth(.4f)
                        .height(1.dp)
                        .background(Color.Black)
                )
                Text(
                    text = "${quote.author}",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Thin
                )

            }

        }

    }
}

