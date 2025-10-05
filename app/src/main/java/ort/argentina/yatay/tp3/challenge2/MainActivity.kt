package ort.argentina.yatay.tp3.challenge2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ort.argentina.yatay.tp3.challenge2.ui.navigation.AppNavigation
import ort.argentina.yatay.tp3.challenge2.ui.theme.Ort_Arg_Yatay_TP3_Challenge2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ort_Arg_Yatay_TP3_Challenge2Theme {
                AppNavigation()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShopListAppPreview() {
    Ort_Arg_Yatay_TP3_Challenge2Theme {
        AppNavigation()
    }
}