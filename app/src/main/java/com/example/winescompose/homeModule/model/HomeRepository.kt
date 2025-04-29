package com.example.winescompose.homeModule.model

import com.example.winescompose.R
import com.example.winescompose.common.entities.MyException
import kotlin.random.Random
import com.example.winescompose.common.entities.Wine
import com.example.winescompose.common.model.BaseRepository
import com.example.winescompose.common.utils.Constants
import com.example.winescompose.homeModule.model.domain.HomeRoomDatabase
import com.example.winescompose.homeModule.model.domain.HomeWineService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeRepository(private val db: HomeRoomDatabase, private val service: HomeWineService) :
    BaseRepository() {

    suspend fun getAllWines(callback: (List<Wine>) -> Unit) = withContext(Dispatchers.IO) {
        executeAction(MyException(Constants.EC_REQUEST, R.string.common_general_fail)) {
            val serverOk = true // if (Random.nextBoolean()) true else Random.nextBoolean()
            val wines = if (serverOk) service.getRedWines() else listOf()
            callback(wines)
        }
    }

    suspend fun addWine(wine: Wine, callback: () -> Unit) = withContext(Dispatchers.IO) {
        executeAction {
            val result = db.addWine(wine)
            if (result == -1L) {
                throw MyException(Constants.EC_SAVE_WINE, R.string.room_save_fail)
            } else {
                callback()
            }
        }

    }
}