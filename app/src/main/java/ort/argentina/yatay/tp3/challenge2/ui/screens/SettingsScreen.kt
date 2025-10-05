package ort.argentina.yatay.tp3.challenge2.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SettingsScreen(paddingValues: PaddingValues) {
    var pushNotifications by remember { mutableStateOf(true) }
    var darkMode by remember { mutableStateOf(true) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(paddingValues)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        // Account Settings Section
        item {
            SectionHeader(text = "Account Settings")
        }

        item {
            SettingsSection {
                SettingsItem(
                    title = "Edit profile",
                    showArrow = true,
                    onClick = { /* TODO: Navigate to edit profile */ }
                )
                Divider(color = Color(0xFFE0E0E0), thickness = 0.5.dp)
                SettingsItem(
                    title = "Change password",
                    showArrow = true,
                    onClick = { /* TODO: Navigate to change password */ }
                )
                Divider(color = Color(0xFFE0E0E0), thickness = 0.5.dp)
                SettingsItemWithSwitch(
                    title = "Push notifications",
                    isChecked = pushNotifications,
                    onCheckedChange = { pushNotifications = it }
                )
                Divider(color = Color(0xFFE0E0E0), thickness = 0.5.dp)
                SettingsItemWithSwitch(
                    title = "Dark mode",
                    isChecked = darkMode,
                    onCheckedChange = { darkMode = it }
                )
            }
        }

        // More Section
        item {
            SectionHeader(text = "More")
        }

        item {
            SettingsSection {
                SettingsItem(
                    title = "About us",
                    showArrow = true,
                    onClick = { /* TODO: Navigate to about us */ }
                )
                Divider(color = Color(0xFFE0E0E0), thickness = 0.5.dp)
                SettingsItem(
                    title = "Privacy policy",
                    showArrow = true,
                    onClick = { /* TODO: Navigate to privacy policy */ }
                )
                Divider(color = Color(0xFFE0E0E0), thickness = 0.5.dp)
                SettingsItem(
                    title = "Terms and conditions",
                    showArrow = true,
                    onClick = { /* TODO: Navigate to terms and conditions */ }
                )
            }
        }
    }
}

@Composable
fun SectionHeader(text: String) {
    Text(
        text = text,
        fontSize = 14.sp,
        color = Color(0xFF999999),
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Composable
fun SettingsSection(
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            modifier = Modifier.padding(vertical = 4.dp)
        ) {
            content()
        }
    }
}

@Composable
fun SettingsItem(
    title: String,
    showArrow: Boolean = false,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            color = Color.Black,
            fontWeight = FontWeight.Normal
        )

        if (showArrow) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "Navigate",
                tint = Color(0xFF999999)
            )
        }
    }
}

@Composable
fun SettingsItemWithSwitch(
    title: String,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            color = Color.Black,
            fontWeight = FontWeight.Normal
        )

        Switch(
            checked = isChecked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.White,
                checkedTrackColor = Color(0xFFFF6B35),
                uncheckedThumbColor = Color.White,
                uncheckedTrackColor = Color(0xFFE0E0E0)
            )
        )
    }
}
