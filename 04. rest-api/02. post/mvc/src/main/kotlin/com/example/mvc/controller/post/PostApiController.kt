package com.example.mvc.controller.post

import com.example.mvc.model.http.UserRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class PostApiController {

    @PostMapping("/post-mapping")
    fun postMapping(): String{
        return "post-mapping"
    }

    @RequestMapping(method = [RequestMethod.POST], path = ["/request-mapping"])
    fun requestMapping(): String{
        return "request-mapping"
    }

    // Post 방식은 body에 내용을 담아서 요청할 수 있음
    // object mapper : json과 object를 받아줄 때 사용
    // json -> object
    // object -> json
    @PostMapping("/post-mapping/object")
    fun postMappingObject(@RequestBody userRequest: UserRequest): UserRequest{
        // json -> object
        println(userRequest)
        return userRequest  // object -> json
    }

}