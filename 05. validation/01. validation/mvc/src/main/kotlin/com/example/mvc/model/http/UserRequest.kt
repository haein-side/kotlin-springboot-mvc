package com.example.mvc.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.constraints.*

data class UserRequest(

        @field:NotEmpty
        @field:Size(min = 2 , max = 8) 
        // data class에서 annotation 붙일 때는 @field를 붙여야 한다!!!!
        // bean을 공통적인 로직을 활용해서 검증하기!
        var name:String?=null,

        @field:PositiveOrZero // 0 < 숫자를 검증 0 도 포함 (양수여야 함)
        var age:Int?=null,

        @field:Email    // email 양식인지 검증
        var email:String?=null,

        @field:NotBlank // 공백이면 안 됨
        var address:String?=null,

        @field:Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}\$")  // 정규식 검증
        var phoneNumber:String?=null,    // phone_number

        var createdAt:String?=null  // yyyy-MM-dd HH:mm:ss   ex) 2020-10-02 13:00:00
){

    // 검증하는 메소드를 직접 만듦! -> custom Annotation으로 만들 수 있음! (StringFormatDateTime)
    // 검증하는 과정에서 메소드를 쓸 수 있도록 @AssertTrue를 붙임 -> validation 시 이 메소드가 실행됨
    @AssertTrue(message = "생성일자의 패턴은 yyyy-MM-dd HH:mm:ss 여야 합니다")
    private fun isValidCreatedAt():Boolean{ // 정상 true , 비정상 false
        return try{
            LocalDateTime.parse(this.createdAt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            true
        }catch (e:Exception){
            false // 예외 발생 시 false 반환
        }
    }

}