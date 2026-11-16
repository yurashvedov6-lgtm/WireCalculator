package com.example.wirecalculator


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ItemRow(model: ItemRowModel){
    Column(horizontalAlignment = Alignment.CenterHorizontally,
       modifier = Modifier
           .padding(3.dp)
           .background(Color.White)
    ) {
        Image(painter = painterResource(id = model.imageId),
            contentDescription = "image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(2.dp)
                .size(65.dp)
                .clip(shape = CircleShape))

        Text(text = model.title)
        Text(text = model.caption)
    }
}
@Preview(showBackground = true)
@Composable
fun ItemRowPreview() {
    ItemRow(
        model = ItemRowModel(
            imageId = R.drawable.newton,
            title = "Ньютон",
            caption = "1643 - 1727"
        )
    )
}

// В этом файле отрисовываем одну карточку по шаблону (модели данных) из файла ItemRowModel.
// 1. В скобках функции ItemRow объявляем параметр (model: ItemRowModel),
// где "model" — это имя параметра (может быть любым),
// а "ItemRowModel" — его тип данных (наш класс-шаблон).
// 2. В Image -> painterResource передаем аргумент id = model.imageId,
// где через точку обращаемся к свойству imageId внутри объекта model.
// 3. Таким же образом через точку передаем свойства title (имя)
// и caption (даты) в компоненты Text().
/*=====================================================================================*/
/**/
