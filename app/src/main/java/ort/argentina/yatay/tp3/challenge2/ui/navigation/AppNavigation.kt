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
import ort.argentina.yatay.tp3.challenge2.ui.screens.EditProfileScreen
import ort.argentina.yatay.tp3.challenge2.ui.screens.SettingsScreen
import ort.argentina.yatay.tp3.challenge2.ui.screens.FavoritesScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation() {
    var selectedTab by remember { mutableStateOf(0) }
    var showMenu by remember { mutableStateOf(false) }
    var showSettings by remember { mutableStateOf(false) }
    var showFavorites by remember { mutableStateOf(false) }
    var showEditProfile by remember { mutableStateOf(false) }

    // Estados para los datos del perfil
    var userName by remember { mutableStateOf("User") }
    var userJob by remember { mutableStateOf("User's job") }
    var email by remember { mutableStateOf("xxx@gmail.com") }
    var phoneNumber by remember { mutableStateOf("+548312315") }
    var website by remember { mutableStateOf("www.google.com") }
    var password by remember { mutableStateOf("xxxxxxxxxxxx") }

    // Determinar si debemos mostrar el botón de regreso
    val showBackButton = showSettings || showFavorites || selectedTab == 4 || showEditProfile

    // Función para regresar a la pantalla principal
    val onBackClick = {
        when {
            showEditProfile -> showEditProfile = false
            showSettings -> showSettings = false
            showFavorites -> showFavorites = false
            selectedTab == 4 -> selectedTab = 0 // Regresar a Home desde Profile
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            ShopListTopAppBar(
                onMenuClick = { showMenu = true },
                showBackButton = showBackButton,
                onBackClick = onBackClick
            )
        },
        bottomBar = {
            if (!showSettings && !showFavorites && !showEditProfile) {
                BottomNavigationBar(
                    selectedTab = selectedTab,
                    onTabSelected = { selectedTab = it }
                )
            }
        }
    ) { paddingValues ->
        // Navegación entre pantallas
        when {
            showEditProfile -> EditProfileScreen(
                paddingValues = paddingValues,
                initialUserName = userName,
                initialUserJob = userJob,
                initialEmail = email,
                initialPhoneNumber = phoneNumber,
                initialWebsite = website,
                initialPassword = password,
                onSave = { newName, newJob, newEmail, newPhone, newWebsite, newPassword ->
                    userName = newName
                    userJob = newJob
                    email = newEmail
                    phoneNumber = newPhone
                    website = newWebsite
                    password = newPassword
                    showEditProfile = false
                },
                onCancel = { showEditProfile = false }
            )
            showSettings -> SettingsScreen(paddingValues)
            showFavorites -> FavoritesScreen(paddingValues)
            else -> {
                when (selectedTab) {
                    0 -> HomeScreen(paddingValues)
                    1 -> SearchScreen(paddingValues)
                    2 -> StoreScreen(paddingValues)
                    3 -> CartScreen(paddingValues)
                    4 -> ProfileScreen(
                        paddingValues = paddingValues,
                        userName = userName,
                        userJob = userJob,
                        email = email,
                        phoneNumber = phoneNumber,
                        website = website,
                        password = password,
                        onEditProfile = { showEditProfile = true }
                    )
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
