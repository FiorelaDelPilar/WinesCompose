package com.example.winescompose.homeModule.model.domain

import com.example.winescompose.common.dataAccess.retrofit.WineService

class HomeWineService(private val service: WineService) {
    suspend fun getRedWines() = service.getRedWines()
}