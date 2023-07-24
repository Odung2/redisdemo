package com.example.redisdemo.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

// OrderStatusException.java


@ResponseStatus(HttpStatus.BAD_REQUEST)
class OrderStatusException(message: String?) : RuntimeException(message) {
    companion object {
        private const val serialVersionUID = 1L
    }
}