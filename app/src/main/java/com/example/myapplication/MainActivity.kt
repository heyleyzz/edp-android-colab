package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Gold = Color(0xFFD4AF37)
private val WhiteText = Color.White
private val LightText = Color(0xFFEAEAEA)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Transparent
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF000000),
                        Color(0xFF17050A),
                        Color(0xFF42101C),
                        Color(0xFF6D1833),
                        Color(0xFF25070F),
                        Color(0xFF000000)
                    )
                )
            )
            .padding(horizontal = 28.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Profile Picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(180.dp)
                .clip(CircleShape)
                .border(4.dp, Gold, CircleShape)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Liz Heart Silubrico",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = WhiteText
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Liceo De Cagayan University",
            fontSize = 13.sp,
            color = Color(0xFFD8D8D8),
            fontWeight = FontWeight.Normal
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Android Developer",
            fontSize = 17.sp,
            fontWeight = FontWeight.Medium,
            color = Gold
        )

        Spacer(modifier = Modifier.height(32.dp))

        ContactCard(
            icon = Icons.Default.Call,
            text = "+63 0997 786 3683"
        )

        Spacer(modifier = Modifier.height(12.dp))

        ContactCard(
            icon = Icons.Default.Share,
            text = "@lizsilubrico"
        )

        Spacer(modifier = Modifier.height(12.dp))

        ContactCard(
            icon = Icons.Default.Email,
            text = "lhsilubrico1893@liceo.edu.ph"
        )
    }
}

@Composable
fun ContactCard(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    text: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.White.copy(alpha = 0.08f),
                shape = RoundedCornerShape(18.dp)
            )
            .border(
                width = 1.dp,
                color = Gold.copy(alpha = 0.35f),
                shape = RoundedCornerShape(18.dp)
            )
            .padding(horizontal = 18.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Gold,
            modifier = Modifier.size(18.dp)
        )

        Spacer(modifier = Modifier.width(14.dp))

        Text(
            text = text,
            color = LightText,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    MaterialTheme {
        BusinessCard()
    }
}