package ca.mavaddat.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import ca.mavaddat.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupSystemUi()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                    BusinessCard(
                        contentPadding = paddingValues
                    )
                }
            }
        }
    }

    private fun setupSystemUi() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }
}

@Composable
fun BusinessCard(contentPadding: PaddingValues) {
    // Top part of the card
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFA83295))
            .padding(contentPadding)
            .padding(bottom = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier
                .widthIn(max = 400.dp)
                .fillMaxWidth(0.5f)
        )
        Text(
            text = "Mavaddat Javid",
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
            color = Color.White,
            fontSize = 36.sp
        )
        Text(
            text = "Android Developer",
            color = Color(0xFF3ddc84)
        )
    }
    // Bottom part of the card
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(contentPadding)
            .padding(bottom = 50.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Row one phone number
        Row {
            Icon(
                painter = painterResource(id = R.drawable.call_24px),
                contentDescription = "Phone icon",
                tint = Color.Unspecified
            )
            Text(
                text = "+11 (123) 456 789",
                color = Color.White,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        // Row two social media handle
        Row {
            Icon(
                painter = painterResource(id = R.drawable.threads_app_logo),
                contentDescription = "Threads icon",
                tint = Color.Unspecified
            )
            Text(
                text = "@mavaddatj",
                color = Color.White,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        // Row three email
        Row {
            Icon(
                painter = painterResource(id = R.drawable.mail_24px),
                contentDescription = "Phone icon",
                tint = Color.Unspecified
            )
            Text(
                text = "mavaddat@email.com",
                color = Color.White,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCard(contentPadding = PaddingValues(0.dp))
    }
}