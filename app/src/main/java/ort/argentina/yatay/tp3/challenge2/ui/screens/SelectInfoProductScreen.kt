package ort.argentina.yatay.tp3.challenge2.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties

@Composable
fun SelectInfoProductScreen(
    paddingValues: PaddingValues,
    onBack: () -> Unit = {},
    onBuy: (selectedSize: String, count: Int) -> Unit = { _, _ -> },
    modifier: Modifier = Modifier
) {
    var selectedSize by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val sizes = listOf("S", "M", "L", "XL", "XXL")
    var count by remember { mutableStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(Color(0xFFF5F0EF))
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Select size",
            fontSize = 22.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF3A2D2D),
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(16.dp))
        // Dropdown clásico para seleccionar tamaño
        Box(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = selectedSize,
                onValueChange = {},
                readOnly = true,
                label = { Text("Input") },
                trailingIcon = {
                    IconButton(onClick = { expanded = !expanded }) {
                        Text(if (expanded) "▲" else "▼")
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded },
                singleLine = true
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.fillMaxWidth(),
                properties = PopupProperties(focusable = false)
            ) {
                sizes.forEach { size ->
                    DropdownMenuItem(
                        text = { Text(size) },
                        onClick = {
                            selectedSize = size
                            expanded = false
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Count of producy",
            fontSize = 22.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF3A2D2D),
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = count.toString(),
            onValueChange = { value ->
                value.toIntOrNull()?.let {
                    if (it > 0) count = it
                }
            },
            label = { Text("Input") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            )
        )
        Spacer(modifier = Modifier.height(48.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(
                onClick = onBack,
                modifier = Modifier.weight(1f)
            ) {
                Text("Back", color = Color(0xFF7B4B2A))
            }
            Spacer(modifier = Modifier.width(32.dp))
            Button(
                onClick = { onBuy(selectedSize, count) },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7B4B2A))
            ) {
                Text("Buy", color = Color.White)
            }
        }
    }
}
