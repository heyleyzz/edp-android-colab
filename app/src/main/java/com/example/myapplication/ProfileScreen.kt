package com.example.myapplication
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.FlowRow import androidx.compose.material3.TopAppBarDefaults
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {

    Scaffold(

        topBar = {

            TopAppBar(

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF2B0A0A),
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White
                ),

                title = {
                    Text("Developer Portfolio")
                },

                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Menu, null)
                    }
                },

                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.MoreVert, null)
                    }
                }

            )

        }

    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(bottom = 40.dp)

        ) {

            item {

                Box {

                    Box(

                        modifier = Modifier
                            .fillMaxWidth()
                            .height(190.dp)
                            .background(

                                Brush.verticalGradient(

                                    colors = listOf(

                                        Color(0xFF140A0A),   // Almost Black
                                        Color(0xFF3D0C11),   // Dark Wine
                                        Color(0xFF6B1E24),   // Burgundy
                                        Color(0xFF8B2635)    // Maroon

                                    )

                                )

                            )

                    )

                    Card(
                        modifier = Modifier
                            .size(165.dp)
                            .align(Alignment.BottomCenter)
                            .offset(y = 60.dp),
                        shape = RoundedCornerShape(24.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp)
                    ) {

                        Image(
                            painter = painterResource(R.drawable.profile),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )

                    }

                }

                Spacer(modifier = Modifier.height(80.dp))

                Column(

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),

                    horizontalAlignment = Alignment.CenterHorizontally

                ) {

                    Text(

                        text = "Liz Heart Silubrico",

                        style = MaterialTheme.typography.headlineMedium,

                        fontWeight = FontWeight.Bold

                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(

                        text = "Android Developer",

                        style = MaterialTheme.typography.titleMedium,

                        color = MaterialTheme.colorScheme.primary

                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(

                        modifier = Modifier.fillMaxWidth(),

                        horizontalArrangement = Arrangement.spacedBy(12.dp)

                    ) {

                        Button(

                            modifier = Modifier.weight(1f),

                            onClick = {}

                        ) {

                            Icon(Icons.Default.Email, null)

                            Spacer(modifier = Modifier.width(8.dp))

                            Text("Email")

                        }

                        OutlinedButton(

                            modifier = Modifier.weight(1f),

                            onClick = {}

                        ) {

                            Icon(Icons.Default.Language, null)

                            Spacer(modifier = Modifier.width(8.dp))

                            Text("Portfolio")

                        }

                    }

                    Spacer(modifier = Modifier.height(28.dp))

                    Text(

                        "Statistics",

                        style = MaterialTheme.typography.titleLarge,

                        fontWeight = FontWeight.Bold,

                        modifier = Modifier.fillMaxWidth()

                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(

                        modifier = Modifier.fillMaxWidth(),

                        horizontalArrangement = Arrangement.spacedBy(12.dp)

                    ) {

                        StatCard(
                            title = "Projects",
                            value = "128",
                            modifier = Modifier.weight(1f)
                        )

                        StatCard(
                            title = "Followers",
                            value = "100K",
                            modifier = Modifier.weight(1f)
                        )

                        StatCard(
                            title = "Following",
                            value = "96",
                            modifier = Modifier.weight(1f)
                        )

                    }

                    Spacer(modifier = Modifier.height(28.dp))

                    Text(

                        "Contact",

                        style = MaterialTheme.typography.titleLarge,

                        fontWeight = FontWeight.Bold,

                        modifier = Modifier.fillMaxWidth()

                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    ElevatedCard(

                        modifier = Modifier.fillMaxWidth(),

                        elevation = CardDefaults.elevatedCardElevation(8.dp)

                    ) {

                        Column(

                            modifier = Modifier.padding(20.dp)

                        ) {

                            InfoRow(
                                icon = Icons.Default.Email,
                                text = "lhsilubrico@gmail.com"
                            )

                            HorizontalDivider(
                                modifier = Modifier.padding(vertical = 10.dp)
                            )

                            InfoRow(
                                icon = Icons.Default.Call,
                                text = "0997863683"
                            )

                            HorizontalDivider(
                                modifier = Modifier.padding(vertical = 10.dp)
                            )
                            InfoRow(
                                icon = Icons.Default.LocationOn,
                                text = "Cagayan de Oro City"
                            )

                            HorizontalDivider(
                                modifier = Modifier.padding(vertical = 10.dp)
                            )

                            InfoRow(
                                icon = Icons.Default.School,
                                text = "Liceo De Cagayan University"
                            )

                        }

                    }

                    Spacer(modifier = Modifier.height(28.dp))

                    Text(

                        "Skills",

                        style = MaterialTheme.typography.titleLarge,

                        fontWeight = FontWeight.Bold,

                        modifier = Modifier.fillMaxWidth()

                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    FlowRow(

                        horizontalArrangement = Arrangement.spacedBy(8.dp),

                        verticalArrangement = Arrangement.spacedBy(8.dp)

                    ) {                         SkillChip("Kotlin")
                        SkillChip("Jetpack Compose")
                        SkillChip("Java")
                        SkillChip("Firebase")
                        SkillChip("Android Studio")
                        SkillChip("Git")
                        SkillChip("XML")
                        SkillChip("Figma")

                    }

                    Spacer(modifier = Modifier.height(28.dp))

                    Text(
                        "Social Links",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    ElevatedCard(
                        modifier = Modifier.fillMaxWidth(),
                        elevation = CardDefaults.elevatedCardElevation(8.dp)
                    ) {

                        Column(
                            modifier = Modifier.padding(20.dp)
                        ) {

                            InfoRow(
                                icon = Icons.Default.Language,
                                text = "github.com/lizheart"
                            )

                            HorizontalDivider(modifier = Modifier.padding(vertical = 10.dp))

                            InfoRow(
                                icon = Icons.Default.Language,
                                text = "linkedin.com/in/lizheart"
                            )

                            HorizontalDivider(modifier = Modifier.padding(vertical = 10.dp))

                            InfoRow(
                                icon = Icons.Default.Language,
                                text = "facebook.com/lizheart"
                            )

                            HorizontalDivider(modifier = Modifier.padding(vertical = 10.dp))

                            InfoRow(
                                icon = Icons.Default.Language,
                                text = "instagram.com/lizheart"
                            )

                            HorizontalDivider(modifier = Modifier.padding(vertical = 10.dp))

                            InfoRow(
                                icon = Icons.Default.Language,
                                text = "portfolio.vercel.app"
                            )

                        }

                    }

                    Spacer(modifier = Modifier.height(16.dp))

                }

            }

        }

    }

}

@Composable
fun StatCard(
    title: String,
    value: String,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                value,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                title,
                style = MaterialTheme.typography.bodyMedium
            )

        }

    }

}

@Composable
fun InfoRow(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    text: String
) {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text,
            style = MaterialTheme.typography.bodyLarge
        )

    }

}

@Composable
fun SkillChip(
    text: String
) {

    FilterChip(
        selected = false,
        onClick = {},
        label = {
            Text(text)
        },
        colors = FilterChipDefaults.filterChipColors()
    )

}