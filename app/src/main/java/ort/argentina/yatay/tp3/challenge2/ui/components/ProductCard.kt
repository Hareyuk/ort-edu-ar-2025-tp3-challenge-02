package ort.argentina.yatay.tp3.challenge2.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProductCard(
    modifier: Modifier = Modifier,
    image: Painter,
    productName: String,
    price: String,
    description: String,
    onAddToFavourite: () -> Unit = {},
    onBuy: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            // Imagen del producto - sin padding, ocupa todo el ancho
            Image(
                painter = image,
                contentDescription = productName,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
                contentScale = ContentScale.Crop
            )

            // Contenido con padding
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                // Nombre del producto
                Text(
                    text = productName,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 20.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Precio
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = price,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "$",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 18.sp
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Descripción
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray,
                    fontSize = 14.sp,
                    lineHeight = 20.sp
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Botones
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // Botón Add to favourite (blanco con borde)
                    OutlinedButton(
                        onClick = onAddToFavourite,
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(24.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = Color.White,
                            contentColor = Color(0xFFB85C3E)
                        )
                    ) {
                        Text(
                            text = "Add to favourite",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    // Botón Buy (marrón)
                    Button(
                        onClick = onBuy,
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(24.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFB85C3E),
                            contentColor = Color.White
                        )
                    ) {
                        Text(
                            text = "Buy",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}
