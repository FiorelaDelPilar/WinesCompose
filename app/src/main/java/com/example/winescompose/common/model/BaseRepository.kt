package com.example.winescompose.common.model

import com.example.winescompose.R
import com.example.winescompose.common.entities.MyException
import com.example.winescompose.common.utils.Constants

open class BaseRepository {
    protected suspend fun executeAction(
        myException: MyException = MyException(Constants.EC_UNKNOWN, R.string.common_unknown_error),
        block: suspend () -> Unit
    ) {
        try {
            block()
        } catch (e: Exception) {
            throw myException
        }
    }
}