package com.example.wirecalculator

data class ScientistItems(
    val imageRes: Int,
    val name: String,
    val caption: String,
    val  biography: String
)
/*сдесь мы создали модель его задача описать структру элемента
тоесть шаблон говорит  что  будет в каждом элементе
 1.у нас это card будет адрес ссылка  на картинку val imageRes: Int
 эта переменная вызывается в файле шаблона в image
 вот эта строка:  painter = painterResource(id = item.imageRes)
 2.val name:String -это имя оно вызывается в первом тексте :
 Text(text = item.name)
 */