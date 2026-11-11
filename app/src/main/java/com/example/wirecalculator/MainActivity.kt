package com.example.wirecalculator

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScientistsScreen()
        }
    }
}

@Composable
fun ScientistsScreen() {
    val context = LocalContext.current

    val scientistsList = listOf(
        ScientistItems(R.drawable.dalton, "Джон Дальтон", "Закон парциальных давлений и атомная теория"),
        ScientistItems(R.drawable.avogadro, "Амедео Авогадро", "Закон Авогадро для газов"),
        ScientistItems(R.drawable.bolcman, "Людвиг Больцман", "Молекулярно-кинетическая теория газов"),
        ScientistItems(R.drawable.maxwell, "Джеймс Максвелл", "Распределение молекул по скоростям")
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(scientistsList) { scientist ->
            ScientistCard(
                item = scientist,
                onItemClick = { clicked ->
                    Toast.makeText(
                        context,
                        "Выбран: ${clicked.name}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            )
        }
    }
}
