package com.example.winescompose.homeModule.model.domain

import com.example.winescompose.common.dataAccess.room.WineDao
import com.example.winescompose.common.entities.Wine

class HomeRoomDatabase(private val dao: WineDao) {
    fun addWine(wine: Wine) = dao.addWine(wine)
}