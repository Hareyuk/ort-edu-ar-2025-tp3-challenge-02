package ort.argentina.yatay.tp3.challenge2.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ort.argentina.yatay.tp3.challenge2.R

@Composable
fun BottomNavigationBar(
    selectedTab: Int = 0,
    onTabSelected: (Int) -> Unit = {}
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color.White,
        shadowElevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            BottomNavItem(
                icon = painterResource(id = R.drawable.baseline_home_24),
                label = "Product",
                isSelected = selectedTab == 0,
                onClick = { onTabSelected(0) }
            )
            BottomNavItem(
                icon = painterResource(id = R.drawable.baseline_search_24),
                label = "Search",
                isSelected = selectedTab == 1,
                onClick = { onTabSelected(1) }
            )
            BottomNavItem(
                icon = painterResource(id = R.drawable.baseline_storefront_24),
                label = "",
                isCenter = true,
                onClick = { onTabSelected(2) }
            )
            BottomNavItem(
                icon = painterResource(id = R.drawable.baseline_shopping_cart_24),
                label = "Cart",
                isSelected = selectedTab == 3,
                onClick = { onTabSelected(3) }
            )
            BottomNavItem(
                icon = painterResource(id = R.drawable.baseline_person_24),
                label = "Profile",
                isSelected = selectedTab == 4,
                onClick = { onTabSelected(4) }
            )
        }
    }
}

@Composable
fun BottomNavItem(
    icon: Painter,
    label: String,
    isSelected: Boolean = false,
    isCenter: Boolean = false,
    onClick: () -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isCenter) {
            Surface(
                shape = androidx.compose.foundation.shape.CircleShape,
                color = Color(0xFFB85C3E),
                modifier = Modifier.size(48.dp),
                onClick = onClick
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Icon(
                        painter = icon,
                        contentDescription = label,
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        } else {
            IconButton(onClick = onClick) {
                Icon(
                    painter = icon,
                    contentDescription = label,
                    tint = if (isSelected) Color(0xFFB85C3E) else Color.Gray,
                    modifier = Modifier.size(24.dp)
                )
            }
            if (label.isNotEmpty()) {
                Text(
                    text = label,
                    style = MaterialTheme.typography.labelSmall,
                    color = if (isSelected) Color(0xFFB85C3E) else Color.Gray,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}
