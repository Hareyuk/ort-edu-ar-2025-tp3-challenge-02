package ort.argentina.yatay.tp3.challenge2.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ort.argentina.yatay.tp3.challenge2.R

@Composable
fun EditProfileScreen(
    paddingValues: PaddingValues,
    initialUserName: String = "User",
    initialUserJob: String = "User's job",
    initialEmail: String = "xxx@gmail.com",
    initialPhoneNumber: String = "+548312315",
    initialWebsite: String = "www.google.com",
    initialPassword: String = "xxxxxxxxxxxx",
    onSave: (String, String, String, String, String, String) -> Unit = { _, _, _, _, _, _ -> },
    onCancel: () -> Unit = {}
) {
    var userName by remember { mutableStateOf(initialUserName) }
    var userJob by remember { mutableStateOf(initialUserJob) }
    var email by remember { mutableStateOf(initialEmail) }
    var phoneNumber by remember { mutableStateOf(initialPhoneNumber) }
    var website by remember { mutableStateOf(initialWebsite) }
    var password by remember { mutableStateOf(initialPassword) }

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

        // Editable User Name
        EditableInputField(
            label = "Name",
            value = userName,
            onValueChange = { userName = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Editable User Job
        EditableInputField(
            label = "Job Title",
            value = userJob,
            onValueChange = { userJob = it }
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Input Fields Column
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // E-Mail Address
            EditableInputField(
                label = "E-Mail Address",
                value = email,
                onValueChange = { email = it }
            )

            // Phone Number
            EditableInputField(
                label = "Phone Number",
                value = phoneNumber,
                onValueChange = { phoneNumber = it }
            )

            // Web Site
            EditableInputField(
                label = "Web Site",
                value = website,
                onValueChange = { website = it }
            )

            // Password
            EditableInputField(
                label = "Password",
                value = password,
                onValueChange = { password = it },
                isPassword = true
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Action Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Cancel Button
            OutlinedButton(
                onClick = onCancel,
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color(0xFFFF6B35)
                ),
                border = androidx.compose.foundation.BorderStroke(2.dp, Color(0xFFFF6B35)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Cancel",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            // Save Button
            Button(
                onClick = { onSave(userName, userJob, email, phoneNumber, website, password) },
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF6B35)
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Save",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
fun EditableInputField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
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
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFFF6B35),
                unfocusedBorderColor = Color(0xFFE0E0E0),
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp),
            singleLine = true,
            visualTransformation = if (isPassword) PasswordVisualTransformation() else androidx.compose.ui.text.input.VisualTransformation.None
        )
    }
}
