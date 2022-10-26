package com.example.mvc.model.http

// 한 번에 객체로 받아서 처리하는 방법
// 변수들을 하나로 감싸주는 data class 생성
data class UserRequest(
        var name:String?=null, // default로 null값을 받음
        var age:Int?=null,
        var email:String?=null,
        var address:String?=null
)