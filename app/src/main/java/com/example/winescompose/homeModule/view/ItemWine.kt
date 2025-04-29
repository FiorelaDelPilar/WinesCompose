package com.example.winescompose.homeModule.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.winescompose.common.components.RatingBar
import com.example.winescompose.common.components.TextList
import com.example.winescompose.common.entities.Rating
import com.example.winescompose.common.entities.Wine
import com.example.winescompose.ui.theme.WinesComposeTheme

/****
 * Project: Wines Compose
 * From: com.cursosant.winescompose.homeModule.view
 * Created by Alain Nicolás Tello on 04/03/24 at 21:17
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
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ItemWine(wine: Wine, modifier: Modifier) {
    Card(modifier = modifier) {
        Box(modifier = modifier) {
            GlideImage(model = wine.image,
                contentDescription = "Wine image",
                modifier = Modifier.matchParentSize(),
                contentScale = ContentScale.Crop)
            Column(modifier = Modifier
                .background(Brush.verticalGradient(
                    colors = listOf(Color(0xaa000000), Color(0xcc000000), Color.Black)
                ))) {
                RatingBar(rating = wine.rating.average.toFloat(), modifier = Modifier.scale(.75f))
                TextList(text = wine.wine, style = typography.titleLarge)
                TextList(text = wine.winery, style = typography.bodyLarge)
                TextList(text = wine.location.replace("\n·", ""), style = typography.bodyMedium)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemPreview() {
    WinesComposeTheme {
        ItemWine(
            wine = Wine("Castilla", "Liria", Rating("4.7", "Good"), "Spain", "", 1.0),
            modifier = Modifier
        )
    }
}