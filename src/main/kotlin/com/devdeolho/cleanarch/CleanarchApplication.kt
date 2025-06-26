package com.devdeolho.cleanarch

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class CleanarchApplication

fun main(args: Array<String>) {
	runApplication<CleanarchApplication>(*args)
}
