package ort.argentina.yatay.tp3.challenge2.ui.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import ort.argentina.yatay.tp3.challenge2.ui.components.BottomNavigationBar
import ort.argentina.yatay.tp3.challenge2.ui.components.MenuContent
import ort.argentina.yatay.tp3.challenge2.ui.components.ShopListTopAppBar
import ort.argentina.yatay.tp3.challenge2.ui.screens.HomeScreen
import ort.argentina.yatay.tp3.challenge2.ui.screens.SearchScreen
import ort.argentina.yatay.tp3.challenge2.ui.screens.StoreScreen
import ort.argentina.yatay.tp3.challenge2.ui.screens.CartScreen
import ort.argentina.yatay.tp3.challenge2.ui.screens.ProfileScreen
import ort.argentina.yatay.tp3.challenge2.ui.screens.SettingsScreen
import ort.argentina.yatay.tp3.challenge2.ui.screens.FavoritesScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation() {
    var selectedTab by remember { mutableStateOf(0) }
    var showMenu by remember { mutableStateOf(false) }
    var showSettings by remember { mutableStateOf(false) }
    var showFavorites by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            ShopListTopAppBar(
                onMenuClick = { showMenu = true }
            )
        },
        bottomBar = {
            if (!showSettings && !showFavorites) {
                BottomNavigationBar(
                    selectedTab = selectedTab,
                    onTabSelected = { selectedTab = it }
                )
            }
        }
    ) { paddingValues ->
        // Navegación entre pantallas
        when {
            showSettings -> SettingsScreen(paddingValues)
            showFavorites -> FavoritesScreen(paddingValues)
            else -> {
                when (selectedTab) {
                    0 -> HomeScreen(paddingValues)
                    1 -> SearchScreen(paddingValues)
                    2 -> StoreScreen(paddingValues)
                    3 -> CartScreen(paddingValues)
                    4 -> ProfileScreen(paddingValues)
                }
            }
        }

        // Mostrar menú lateral si está activado
        if (showMenu) {
            ModalBottomSheet(
                onDismissRequest = { showMenu = false },
                sheetState = rememberModalBottomSheetState(),
                dragHandle = { BottomSheetDefaults.DragHandle() },
                containerColor = Color(0xFFFFF4F1),
                modifier = Modifier.fillMaxHeight(0.9f)
            ) {
                MenuContent(
                    onDismiss = { showMenu = false },
                    onMenuItemClick = { menuItem ->
                        when (menuItem) {
                            "shop_list" -> {
                                selectedTab = 0
                                showSettings = false
                                showFavorites = false
                            }
                            "favourites" -> {
                                showFavorites = true
                                showSettings = false
                            }
                            "profile" -> {
                                selectedTab = 4
                                showSettings = false
                                showFavorites = false
                            }
                            "settings" -> {
                                showSettings = true
                                showFavorites = false
                            }
                        }
                        showMenu = false
                    }
                )
            }
        }
    }
}
