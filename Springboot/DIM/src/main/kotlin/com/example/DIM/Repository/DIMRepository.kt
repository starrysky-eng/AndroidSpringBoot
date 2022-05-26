package com.example.DIM.Repository

import com.example.DIM.model.DIMModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface DIMRepository : CrudRepository<DIMModel,Int> {
}