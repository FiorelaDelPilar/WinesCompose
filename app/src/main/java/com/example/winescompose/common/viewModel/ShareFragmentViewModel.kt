package com.example.winescompose.common.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShareFragmentViewModel : ViewModel() {
    val isDismiss = MutableLiveData<Boolean>()
}