package com.example.DIM

import com.example.DIM.model.DIMModel
import com.example.DIM.service.DIMService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class DimApplicationTests {
	@Autowired
	lateinit var dimService: DIMService
	@Test
	fun addUserData() {
		val dimModel = DIMModel()
		dimModel.name = "1111"
		dimModel.password = "2222"
		dimService.addUser(dimModel)
	}

}
