package ort.argentina.yatay.tp3.challenge2.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ort.argentina.yatay.tp3.challenge2.R

@Composable
fun ProfileScreen( //Valores por defaultq ue indiqué que muestre en caso de no recibir información de afuera
    paddingValues: PaddingValues,
    userName: String = "User",
    userJob: String = "User's job",
    email: String = "xxx@gmail.com",
    phoneNumber: String = "+548312315",
    website: String = "www.google.com",
    password: String = "xxxxxxxxxxxx",
    onEditProfile: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(paddingValues)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Profile Image with edit button
        Box(
            modifier = Modifier.size(120.dp)
        ) {
            // Profile Image with circular shape
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
                    .background(Color.Gray.copy(alpha = 0.3f)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.placeholder_pfp),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }

            // Edit button with pencil icon
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .align(Alignment.BottomEnd)
                    .clip(CircleShape)
                    .background(Color(0xFFFF6B35)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_create_24),
                    contentDescription = "Edit Profile",
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // User Name
        Text(
            text = userName,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        // User Job
        Text(
            text = userJob,
            fontSize = 14.sp,
            color = Color(0xFF999999),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(40.dp))

        // Input Fields Column
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // E-Mail Address
            ProfileInputField(
                label = "E-Mail Address",
                value = email
            )

            // Phone Number
            ProfileInputField(
                label = "Phone Number",
                value = phoneNumber
            )

            // Web Site
            ProfileInputField(
                label = "Web Site",
                value = website
            )

            // Password
            ProfileInputField(
                label = "Password",
                value = password,
                isPassword = true
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Edit Button
        Button(
            onClick = onEditProfile,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF6B35)
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text = "Edit",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
fun ProfileInputField(
    label: String,
    value: String,
    isPassword: Boolean = false
) {
    Column {
        Text(
            text = label,
            fontSize = 12.sp,
            color = Color(0xFF999999),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = value,
            onValueChange = { /* Static view, no editing */ },
            modifier = Modifier.fillMaxWidth(),
            enabled = false,
            colors = OutlinedTextFieldDefaults.colors(
                disabledTextColor = Color.Black,
                disabledBorderColor = Color(0xFFE0E0E0),
                disabledContainerColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp),
            singleLine = true
        )
    }
}
