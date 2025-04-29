package com.example.winescompose.common.dataAccess.retrofit

import com.example.winescompose.common.utils.Constants
import com.example.winescompose.common.entities.Wine
import retrofit2.http.GET

/****
 * Project: Wines
 * From: com.cursosant.wines
 * Created by Alain Nicolás Tello on 06/02/24 at 20:23
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
interface WineService {
    // https://sampleapis.com/api-list/wines
    @GET(Constants.PATH_WINES)
    suspend fun getRedWines() : List<Wine>
}