package com.example.fullstackapplication

data class ContactVO(val name : String, val age : Int, val tel : String) {
    // 만약, FireBase 의 RealTime Database 용으로
    // 사용되는 VO Class 라면, 반드시!! 기본 생성자가 정의되어야 한다!!

    constructor() : this("",0,"") // 코틀린에서 기본생성자 만드는방법 아무것도 없는!
}