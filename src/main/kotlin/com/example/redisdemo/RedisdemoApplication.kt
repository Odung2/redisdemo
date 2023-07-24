package com.example.redisdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching //Redis Cache 사용
class RedisdemoApplication

fun main(args: Array<String>) {
	runApplication<RedisdemoApplication>(*args)
}
