package com.example.winescompose

import android.app.Application
import com.example.winescompose.common.di.dataSourceModule
import com.example.winescompose.homeModule.di.homeModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

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
class WineApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@WineApplication)
            modules(
                dataSourceModule,
                homeModule
            )
        }
    }
}