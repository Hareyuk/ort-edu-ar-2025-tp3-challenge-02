package ort.argentina.yatay.tp3.challenge2.data

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import ort.argentina.yatay.tp3.challenge2.ui.screens.ProductData

object FavoritesManager {
    private val _favorites: SnapshotStateList<ProductData> = mutableStateListOf()
    val favorites: List<ProductData> get() = _favorites

    fun addToFavorites(product: ProductData) {
        if (!_favorites.contains(product)) {
            _favorites.add(product)
        }
    }

    fun removeFromFavorites(product: ProductData) {
        _favorites.remove(product)
    }

    fun isFavorite(product: ProductData): Boolean {
        return _favorites.contains(product)
    }

    fun toggleFavorite(product: ProductData) {
        if (isFavorite(product)) {
            removeFromFavorites(product)
        } else {
            addToFavorites(product)
        }
    }
}
