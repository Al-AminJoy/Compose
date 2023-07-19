package com.alamin.compose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alamin.compose.ui.theme.ComposeTheme

class CheezyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                PreviewGenerator()
            }
        }
    }

    @Preview()
    @Composable
    fun PreviewGenerator(modifier: Modifier = Modifier) {
        var dataList by remember {
            mutableStateOf(mutableListOf<Int>(1,2,3,5,6))
        }

        dataList.add(9)

        LazyColumn(){
            items(dataList){item ->
                SayHello(index = item)
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SayHello(index:Int) {

        Card(modifier = Modifier.padding(8.dp), elevation = CardDefaults.cardElevation(4.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth().padding(8.dp)) {

                Spacer(modifier = Modifier.size(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    modifier = Modifier
                        .size(40.dp)
                        .padding(4.dp),
                    contentDescription = null
                )
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = "Title No. $index", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Subtitle No. $index", fontSize = 12.sp)
                }
            }

        }

    }
}