package com.example.DIM

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@SpringBootApplication
@EntityScan(basePackages = ["com.example.DIM.model"])
class DimApplication
fun main(args: Array<String>) {
	runApplication<DimApplication>(*args)
}
