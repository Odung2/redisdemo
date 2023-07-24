package com.example.redisdemo.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

// OrderNotFoundException.java


@ResponseStatus(HttpStatus.NOT_FOUND)
class OrderNotFoundException(message: String?) : RuntimeException(message) {
    companion object {
        private const val serialVersionUID = 1L
    }
}