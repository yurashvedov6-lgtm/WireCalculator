package com.example.wirecalculator // Замените на имя вашего пакета, если оно отличается


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Разворачиваем наш UI внутри MainActivity
        setContent {
            val myItems = listOf("first","second","third","fourth","fifth")
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
                    .background(Color.Magenta),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,

                )
            {
                itemsIndexed(myItems) {index,items ->
                    Text(
                        text = items,
                        style = TextStyle
                            (fontSize = 45.sp),
                        color = Color.White
                    )
                }
            }
        }
    }
}

/* 1.в этом третьем  уроке LessonList_2.txt про список
2.Мы пытаемся создать список с помощью LazyColumn но вместо фу items мы создаем
фу itemsIndecsed
2. В скобках в пораметры записываем переменную с присвоиным списком listOF()
3.В фигурных скобках записываем порядковый номер Indexs и элементs items
4.Этими фиг скобками оборачиваем Text в которым выводим переменную items
 */
