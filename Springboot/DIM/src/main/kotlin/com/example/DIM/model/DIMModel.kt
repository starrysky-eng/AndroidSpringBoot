package com.example.DIM.model

import javax.persistence.*

@Entity
class DIMModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int = 0
    var name:String = ""
    var password:String = ""
}