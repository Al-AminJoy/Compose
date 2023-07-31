package com.alamin.compose.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview()
@Composable
fun QuotesListItem() {
    Card(elevation = CardDefaults.cardElevation(4.dp), modifier = Modifier.padding(4.dp)) {

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
                    text = "Quotes Title",
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
                    text = "Author",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Thin
                )

            }

        }

    }
}

@Preview
@Composable
fun QuotesDetails() {
    Box(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(Brush.linearGradient(colors = listOf(Color.LightGray, Color.Gray))),
        contentAlignment = Alignment.Center
    ) {
        Card(
            elevation = CardDefaults.cardElevation(4.dp), colors = CardDefaults.cardColors(Color.White), modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)

        ) {
            Column(
                verticalArrangement = Arrangement.Center, modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            ) {

                Image(
                    imageVector = Icons.Filled.FormatQuote,
                    modifier = Modifier
                        .rotate(180f)
                        .padding(4.dp),
                    contentDescription = null
                )

                Text(
                    text = "Quotes",
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Image(
                    imageVector = Icons.Filled.FormatQuote,
                    modifier = Modifier
                        .align(alignment = Alignment.End)
                        .padding(4.dp),
                    contentDescription = null
                )

                Spacer(modifier = Modifier.size(4.dp))

                Text(
                    text = "Author",
                    color = Color.DarkGray,
                    modifier = Modifier
                        .padding(end = 4.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.End
                )

            }

        }

    }
}