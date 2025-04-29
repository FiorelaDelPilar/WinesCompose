package com.example.winescompose.homeModule.viewModel

import com.example.winescompose.R
import com.example.winescompose.common.entities.Wine
import com.example.winescompose.common.viewModel.BaseWineViewModel
import com.example.winescompose.homeModule.model.HomeRepository

class HomeViewModel(private val repository: HomeRepository) : BaseWineViewModel() {
    init {
        getAllWines()
    }

    override fun onPause() = clearValues()

    override fun getAllWines() {
        executeAction {
            repository.getAllWines { wines ->
                setWines(wines)
            }
        }
    }

    fun addWine(wine: Wine) {
        executeAction {
            repository.addWine(wine) {
                setSnackbarMsg(R.string.room_save_success)

            }
        }
    }
}