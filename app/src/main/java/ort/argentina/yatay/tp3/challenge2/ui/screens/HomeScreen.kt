package ort.argentina.yatay.tp3.challenge2.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ort.argentina.yatay.tp3.challenge2.R
import ort.argentina.yatay.tp3.challenge2.ui.components.ProductCard
import ort.argentina.yatay.tp3.challenge2.data.FavoritesManager

@Composable
fun HomeScreen(paddingValues: PaddingValues) {
    // Lista de productos de ejemplo
    val products = listOf(
        ProductData(
            id = 1,
            image = R.drawable.placeholder_shoes,
            name = "Leather boots",
            price = "27,5",
            description = "Great warm shoes from the artificial leather. You can buy this model only in our shop"
        ),
        ProductData(
            id = 2,
            image = R.drawable.placeholder_shoes,
            name = "Running Sneakers",
            price = "45,0",
            description = "Comfortable running shoes perfect for daily exercise and casual wear"
        ),
        ProductData(
            id = 3,
            image = R.drawable.placeholder_shoes,
            name = "Classic Oxfords",
            price = "89,9",
            description = "Elegant leather shoes suitable for formal occasions and business meetings"
        ),
        ProductData(
            id = 4,
            image = R.drawable.placeholder_shoes,
            name = "Canvas Shoes",
            price = "32,0",
            description = "Casual canvas shoes perfect for weekend activities and relaxed outings"
        )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        items(products) { product ->
            ProductCard(
                image = painterResource(id = product.image),
                productName = product.name,
                price = product.price,
                description = product.description,
                onAddToFavourite = {
                    FavoritesManager.addToFavorites(product)
                },
                onBuy = {
                    // TODO: Implementar lógica de compra
                }
            )
        }
    }
}

// Data class para los productos
data class ProductData(
    val id: Int,
    val image: Int,
    val name: String,
    val price: String,
    val description: String
)
