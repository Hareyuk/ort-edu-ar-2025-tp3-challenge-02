package ort.argentina.yatay.tp3.challenge2.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ort.argentina.yatay.tp3.challenge2.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuContent(
    onDismiss: () -> Unit = {},
    onMenuItemClick: (String) -> Unit = {}
) {
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
            isSelected = true,
            onClick = { onMenuItemClick("shop_list") }
        )
        MenuItemRow(
            icon = painterResource(id = R.drawable.baseline_favorite_24),
            text = "Favourites",
            count = "3",
            onClick = { onMenuItemClick("favourites") }
        )
        MenuItemRow(
            icon = painterResource(id = R.drawable.outline_account_circle_24),
            text = "Profile",
            onClick = { onMenuItemClick("profile") }
        )
        MenuItemRow(
            icon = painterResource(id = R.drawable.baseline_settings_24),
            text = "Settings",
            onClick = { onMenuItemClick("settings") }
        )
    }
}

@Composable
fun MenuItemRow(
    icon: Painter,
    text: String,
    isSelected: Boolean = false,
    count: String? = null,
    onClick: () -> Unit = {}
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        color = if (isSelected) Color(0xFFFFE4DA) else Color.Transparent,
        shape = RoundedCornerShape(12.dp),
        onClick = onClick
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
