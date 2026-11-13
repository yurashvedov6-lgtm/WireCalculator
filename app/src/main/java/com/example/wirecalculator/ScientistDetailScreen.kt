package com.example.wirecalculator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
// Экран подробной информации об ученом, который открывается при нажатии на карточку
fun ScientistDetailScreen(
    // Данные выбранного ученого (имя, фото, биография)
    scientist: ScientistItems,
    // Действие, которое выполнится при нажатии на кнопку «Назад»
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = scientist.biography)
        Button(onClick = onBackClick) {
            Text(text = "← Назад")
        }
    }
}
// это файл отрисовки экрана (screen ) когда произойдет нажатие на card