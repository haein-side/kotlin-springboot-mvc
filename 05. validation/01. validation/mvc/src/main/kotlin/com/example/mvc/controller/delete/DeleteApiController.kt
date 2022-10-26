package com.example.mvc.controller.delete

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@RestController
@RequestMapping("/api")
@Validated // HTTP 요청에 대해 검증하는 Anotation들이 동작
class DeleteApiController {

    // 1. path variable
    // 2. request param

    @DeleteMapping(path = ["/delete-mapping"])
    fun deleteMapping(
            @RequestParam(value = "name") _name : String,

            // HTTP 요청에 대해 검증하는 Annotation
            @NotNull(message = "age 값이 누락되었습니다.")
            @Min(value = 20, message = "age는 20보다 커야 합니다.")
            @RequestParam(name = "age") _age : Int // _age는 Bean이 아니기 때문에 검증해주기 위해서는 @Validated가 필요
    ): String{
        println(_name)
        println(_age)
        return _name+" "+_age
    }

    @DeleteMapping(path = ["/delete-mapping/name/{name}/age/{age}"])
    fun deleteMappingPath(@PathVariable(value = "name")
                          @Size(min = 2, max = 5, message = "name의 길이는 2~5") // _name의 길이 제한
                          @NotNull // _name은 Null이면 안 됨!
                          _name:String, // aa ~ aaaaa

                          @NotNull(message = "age 값이 누락되었습니다.")
                          @Min(value = 20, message = "age는 20보다 커야 합니다.")
                          @PathVariable(name = "age") _age:Int): String {
        println(_name)
        println(_age)
        return _name+" "+_age
    }

}