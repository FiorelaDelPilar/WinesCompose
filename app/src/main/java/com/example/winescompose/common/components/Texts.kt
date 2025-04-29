package com.example.winescompose.common.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

/****
 * Project: Wines Compose
 * From: com.cursosant.winescompose.common.components
 * Created by Alain Nicolás Tello on 06/03/24 at 15:17
 * All rights reserved 2024.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * And Frogames formación:
 * https://cursos.frogamesformacion.com/pages/instructor-alain-nicolas
 *
 * Coupons on my Website:
 * www.alainnicolastello.com
 ***/
@Composable
fun TextList(text: String, style: TextStyle) {
    Text(text = text, modifier = Modifier
        .padding(horizontal = 8.dp), color = Color.White, style = style)
}