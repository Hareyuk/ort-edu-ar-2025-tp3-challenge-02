package ort.argentina.yatay.tp3.challenge2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ort.argentina.yatay.tp3.challenge2.ui.theme.Ort_Arg_Yatay_TP3_Challenge2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ort_Arg_Yatay_TP3_Challenge2Theme {
                ShopListApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopListApp() {
    var showMenu by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            ShopListTopAppBar(
                onMenuClick = { showMenu = true }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Text(text = "Contenido principal")

            if (showMenu) {
                ModalBottomSheet(
                    onDismissRequest = { showMenu = false },
                    sheetState = rememberModalBottomSheetState(),
                    dragHandle = { BottomSheetDefaults.DragHandle() },
                    containerColor = Color(0xFFFFF4F1),
                    modifier = Modifier.fillMaxHeight(0.9f)
                ) {
                    MenuContent()
                }
            }
        }
    }
}

@Composable
fun MenuContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Title",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Section Header",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        // Menú items
        MenuItemRow(
            icon = painterResource(id = R.drawable.baseline_menu_24),
            text = "Shop list",
            isSelected = true
        )
        MenuItemRow(
            icon = painterResource(id = R.drawable.baseline_favorite_24),
            text = "Favourites",
            count = "3"
        )
        MenuItemRow(
            icon = painterResource(id = R.drawable.outline_account_circle_24),
            text = "Profile"
        )
        MenuItemRow(
            icon = painterResource(id = R.drawable.baseline_settings_24),
            text = "Settings"
        )
    }
}

@Composable
fun MenuItemRow(
    icon: Painter,
    text: String,
    isSelected: Boolean = false,
    count: String? = null
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        color = if (isSelected) Color(0xFFFFE4DA) else Color.Transparent,
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                Icon(
                    painter = icon,
                    contentDescription = text,
                    modifier = Modifier.padding(end = 12.dp)
                )
                Text(text = text)
            }
            if (count != null) {
                Text(text = count)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopListTopAppBar(onMenuClick: () -> Unit) {
    CenterAlignedTopAppBar(
        navigationIcon = {
            IconButton(onClick = onMenuClick) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_menu_24),
                    contentDescription = "Menú"
                )
            }
        },
        title = {
            Text(
                text = "Shop list",
                fontFamily = FontFamily.Default
            )
        },
        actions = {
            IconButton(onClick = { /* Por ahora sin acción */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.outline_account_circle_24),
                    contentDescription = "Perfil"
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors()
    )
}

@Preview(showBackground = true)
@Composable
fun ShopListAppPreview() {
    Ort_Arg_Yatay_TP3_Challenge2Theme {
        ShopListApp()
    }
}