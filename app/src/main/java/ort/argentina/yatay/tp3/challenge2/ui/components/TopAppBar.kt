package ort.argentina.yatay.tp3.challenge2.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import ort.argentina.yatay.tp3.challenge2.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopListTopAppBar(
    onMenuClick: () -> Unit,
    showBackButton: Boolean = false,
    onBackClick: () -> Unit = {}
) {
    CenterAlignedTopAppBar(
        navigationIcon = {
            IconButton(onClick = if (showBackButton) onBackClick else onMenuClick) {
                Icon(
                    painter = painterResource(
                        id = if (showBackButton)
                            R.drawable.outline_arrow_back_24
                        else
                            R.drawable.baseline_menu_24
                    ),
                    contentDescription = if (showBackButton) "Regresar" else "Menú"
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
        colors = TopAppBarDefaults.topAppBarColors()
    )
}
