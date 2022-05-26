package com.example.DIM.service

import com.example.DIM.Repository.DIMRepository
import com.example.DIM.model.DIMModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DIMService {
    @Autowired
    private lateinit var dimRepository: DIMRepository
    fun addUser(dimModel: DIMModel) {
        dimRepository.save(dimModel)
    }
}