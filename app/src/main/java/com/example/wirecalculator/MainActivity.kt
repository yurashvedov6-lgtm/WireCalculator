package com.example.wirecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
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
    //1.ПАМЯТЬ ЭКРАНА переменная selectedScientist   хронит выбранного ученого
    // ? знак обозначает когда ученый не выбран внутри пусто null
    //remember не дает значкнию сбросится при перерисовки экрана
    //mutableStateOF заставить экран перерисоваться или автоматически
    //обновиться  когда значение изменится тоесь произоцдет нажатие на Card
    var selectedScientist by remember { mutableStateOf<ScientistItems?>(null) }
    // 2.ПРОВЕРКА УСЛОВИЯ (Переключатель экранов )
    if (selectedScientist != null) {
        // 3.ЭКРАН БИОГРАФИИ если ученый выбран
        ScientistDetailScreen(// Открывается экран биографии
            scientist = selectedScientist!!,
            onBackClick = { selectedScientist = null }//закрывает экран биографии
        )
    } else {
        //4.СПИСОК УЧЕНЫХ
        //Если в переменной SelectedScientist = null пусто то рисует список ученых
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {

            //scientistLists это переменная из файла scientistData.kt
            // в которую записаны все ученые
            //перебираем всех ученых из файла scientistData.kt
            items(scientistsList) { scientist ->
                //для каждого ученого рисуем карточку по шаблону файл ScientistCard
                ScientistCard(
                    // Передаем данные конкретного ученого в карточку для отображения
                    item = scientist,
                    // Описываем действие при клике: сохраняем выбранного ученого в переменную состояния,
                    // чтобы Compose перерисовал интерфейс и открыл экран ScientistDetailScreen
                    onItemClick = { clicked ->
                        selectedScientist = clicked
                    }
                )
            }
        }
    }
}
/* фу cientistsScreen() 1.управляет состоянием выбранного ученого
2.и переключает интерфейс между общим списком LazyColumn
 и экраном подробной биографии ScientistDetailScreen.
*/
/*=================================================================================================*/
                                    /*АРХИТЕКТУРА ПРОЕКТА */
/*
1. Передача данных В ШАБЛОН (из MainActivity в ScientistCard)

Когда список LazyColumn строит экран, он берет шаблон ScientistCard и наполняет его начинкой:
• item = scientist — главный экран кладет в шаблон конкретного ученого (например, Джона Дальтона),
чтобы шаблон знал, чье фото и имя нарисовать.
• onItemClick = { ... } — главный экран дает шаблону инструкцию на будущее:
 «Если пользователь на тебя нажмет, сообщи мне, кто именно это был».

2. Нажатие пользователя (внутри ScientistCard)

Пользователь видит готовую карточку на экране и нажимает на неё пальцем.
Срабатывает строчка .clickable { onItemClick(item) },
которая запускает ту самую инструкцию, оставленную главным экраном.

3. Возврат данных ОБРАТНО (из ScientistCard в MainActivity)

Шаблон стучится обратно в MainActivity и возвращает свой item (того самого Джона Дальтона).
• В MainActivity этот вернувшийся объект попадает в переменную clicked.
• Срабатывает строка selectedScientist = clicked.
• Переменная selectedScientist перестает быть пустой (null),
интерфейс мгновенно перестраивается и открывает экран биографии ScientistDetailScreen.
*/