package com.example.DIM.controller

import com.example.DIM.model.DIMModel
import com.example.DIM.service.DIMService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class DIMController {
    @Autowired
    private lateinit var dimService: DIMService

    @PostMapping("/DIM/save")
    fun save(@RequestBody dimModel: DIMModel){
        val result = dimService.addUser(dimModel)
        if(result != null){
            println("OK")
        }
        else{
            println("Error")
        }
    }
}