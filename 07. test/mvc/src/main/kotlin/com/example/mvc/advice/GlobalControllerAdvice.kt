package com.example.mvc.advice

import com.example.mvc.controller.exception.ExceptionApiController
import com.example.mvc.controller.put.PutApiController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

// Global하게 exception 잡는 케이스

//@RestControllerAdvice
//@RestController에서 발생하는 Exception들이 여기를 통과하게 됨
//@RestControllerAdvice(basePackageClasses = [ExceptionApiController::class])
//ExceptionApiController에서 발생하는 Exception이 여기를 통과
class GlobalControllerAdvice {

    @ExceptionHandler(value = [RuntimeException::class]) // 모든 에러를 다 잡음
    fun exception(e : RuntimeException): String{ // 에러가 매개변수 e로 들어옴
        return "Server Error"
    }

    @ExceptionHandler(value = [IndexOutOfBoundsException::class]) // IndexOutOfBoundsException 발생 시 여기로 들어옴
    fun indexOutOfBoundsException(e: IndexOutOfBoundsException): ResponseEntity<String>{    // 200 OK
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Index Error")
    }
}