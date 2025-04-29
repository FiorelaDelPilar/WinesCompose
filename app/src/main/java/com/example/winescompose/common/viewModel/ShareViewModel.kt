package com.example.winescompose.common.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShareViewModel : ViewModel() {
    val showNavView = MutableLiveData<Boolean>()
    val isSignOut = MutableLiveData<Boolean>()
}