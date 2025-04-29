package com.example.winescompose.common.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.winescompose.common.entities.MyException
import com.example.winescompose.common.utils.Constants
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {
    private val _inProgess = MutableLiveData<Boolean>()
    val inProgess: LiveData<Boolean> = _inProgess

    private val _snackbarMsg = MutableLiveData<Int?>()
    val snackbarMsg: LiveData<Int?> = _snackbarMsg

    protected fun setInProgress(value: Boolean) {
        _inProgess.postValue(value)
    }

    protected fun setSnackbarMsg(value: Int?) {
        _snackbarMsg.postValue(value)
    }

    open fun onPause() {
    }

    protected fun clearValues() {
        setSnackbarMsg(null)
    }

    protected fun executeAction(block: suspend () -> Unit): Job {
        return viewModelScope.launch {
            _inProgess.value = Constants.SHOW
            try {
                block()
            } catch (e: MyException) {
                _snackbarMsg.value = e.resMsg

            } finally {
                _inProgess.value = Constants.HIDE
            }
        }
    }
}