package com.example.profileui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profileui.ui.theme.ProfileUiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfileUiTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        color = MaterialTheme.colorScheme.background // Use theme background color
                    ) {
                        ProfileScreen()
                    }
                }
            }
        }
    }
}

/**
 * An enhanced version of the profile screen with better UI/UX.
 */
@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    // A single scrollable column for the entire screen to ensure responsiveness.
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        // --- HEADER SECTION ---
        // A Box allows us to layer the banner image and the profile picture.
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp), // Increased height for a more prominent header
            contentAlignment = Alignment.Center // Center the content (the profile picture)
        ) {
            // Enabled this as the working background. It uses a color from your app's theme.
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.secondaryContainer)
            )

            // Profile Picture, now layered on top of the banner
            Image(
                painter = painterResource(id = R.drawable.ganda_lang),
                contentDescription = "User profile picture",
                modifier = Modifier
                    .size(130.dp)
                    .clip(CircleShape)
                    .border(4.dp, Color.White, CircleShape) // A white border helps it stand out from the banner
            )
        }

        // Add space between the header and the user info
        Spacer(modifier = Modifier.height(16.dp))

        // --- USER INFO & BIO SECTION ---
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Jasmine De Leon",
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp, // Slightly larger for more emphasis
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(8.dp))

            // A shorter, more impactful title or role
            Text(
                text = "IT Student | Aspiring Cybersecurity Professional",
                fontSize = 17.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )

            // A larger spacer to separate the title from the long bio text
            Spacer(modifier = Modifier.height(24.dp))

            // --- About Me Section ---
            Text(
                text = "IT student with a strong passion for technology, problem-solving, and continuous learning.",
                fontSize = 16.sp,
                textAlign = TextAlign.Start, // Left-aligned text is easier to read for long paragraphs
                lineHeight = 24.sp, // Increased line height improves readability
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        // --- EDIT BUTTON ---
        // Placed at the bottom with more space around it
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 32.dp),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = { Toast.makeText(context, "Edit button clicked!", Toast.LENGTH_SHORT).show() },
                modifier = Modifier.fillMaxWidth(0.8f) // Make it slightly wider
            ) {
                Text(
                    text = "Edit Profile",
                    fontSize = 16.sp, // Make button text slightly larger
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
        }
    }
}


// --- PREVIEWS ---

@Preview(showBackground = true, name = "Enhanced Portrait Preview")
@Composable
fun ProfileScreenPreview() {
    ProfileUiTheme {
        Surface {
            ProfileScreen()
        }
    }
}

@Preview(showBackground = true, widthDp = 800, heightDp = 480, name = "Enhanced Landscape Preview")
@Composable
fun ProfileScreenLandscapePreview() {
    ProfileUiTheme {
        Surface {
            ProfileScreen()
        }
    }
}


