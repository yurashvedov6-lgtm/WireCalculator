package com.example.wirecalculator // Замените на имя вашего пакета, если оно отличается


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wirecalculator.ui.theme.Gray100


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Разворачиваем наш UI внутри MainActivity
        setContent {
            val scientistItems = listOf(
                ItemRowModel(R.drawable.newton , title ="Ньютон"," 1643 -1727"),
                ItemRowModel(R.drawable.leibniz , title ="Лейбниц" ,caption = "1646 -1716"),
                ItemRowModel(R.drawable.huygens, title ="Христиан Гюйгенс" ,"1629-1695"),
                ItemRowModel(R.drawable.hooke, title ="Роберт Хук", "1635 -1703")
            )
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .background(Gray100),
                //verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement  = Arrangement.Center,

                )
            {
                itemsIndexed(scientistItems) {_,model ->
ItemRow(model = model)
                }
            }
        }
    }
}

/* 1.в этой ветке Git lessonSeven

1.Работаю github нахожусь в состоян Detached HEAD вне веток если сделать commit
его будет сложно найти.
2.Создаем ветку прямо сейчас в нижней вкладке git на строчку с желтой меткой
Detached HEAD жмем правой кнопкой мыши и выбираем New Branch .
3.После делаем название lessonSeven
 */
/*===============================================================================*/
/*
/*
 * 1. Создал переменную scientistItems и присвоил ей результат функции listOf(),
 поместив внутрь список из четырех объектов.
 */
 * 2. Для создания каждого объекта использовал конструктор класса ItemRowModel() и
 передал данные (аргументы) в его свойства (imageId, title, caption).
 */

 /*
 *    (Памятка: у класса внутри хранятся свойства,
 * при объявлении функции в скобках пишутся параметры,
  а при вызове функции передаются аргументы).
 */
/*
 * 3. Передал переменную scientistItems как аргумент в функцию itemsIndexed.
 * 4. В файле ItemRow.kt объявил параметр с придуманным именем model (типа ItemRowModel).
 * 5. Внутри itemsIndexed каждый объект из списка по очереди передается в этот параметр model,
и по единому шаблону из ItemRow.kt отрисовываются все карточки.


 */
