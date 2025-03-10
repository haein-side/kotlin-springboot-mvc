package com.example.mvc.controller.get

import com.example.mvc.model.http.UserRequest
import org.springframework.web.bind.annotation.*

@RestController         // REST API Controller 동작
@RequestMapping("/api") // http://localhost:8080/api
class GetApiController {

    @GetMapping(path = ["/hello","/abcd"])   // GET http://localhost:8080/api/hello , GET http://localhost:8080/api/abcd
    fun hello(): String{
        return "hello kotlin"
    }

    @RequestMapping(method = [RequestMethod.GET], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping"
    }

    @GetMapping("/get-mapping/path-variable/{name}/{age}") // GET http://localhost:8080/api/get-mapping/path-variable/steve
    fun pathVariable(@PathVariable name: String, @PathVariable age:Int): String{
        // pathVariable name은 요청들어온 URI의 {name}과 일치하면 됨!
        println("${name} , ${age}")
        return name+" "+age
    }

    @GetMapping("/get-mapping/path-variable2/{name}/{age}") // GET http://localhost:8080/api/get-mapping/path-variable/steve
    fun pathVariable2(@PathVariable(value = "name") _name: String, @PathVariable(name = "age") age:Int): String{
        // 요청 들어온 URI의 name 속성이 다른 변수명과 일치할 때
        // PathVariable 속성 중 value라는 속성을 사용하면 _name을 name처럼 쓸 수 있음!
        // 또는 name이라는 속성을 사용해서 path를 맞춰주면 됨!
        val name = "kotlin"
        println("${_name} , ${age}")
        return _name+" "+age
    }

    // htts://localhost:8080/api/page?key=value&key=value&key=value
    @GetMapping("/get-mapping/query-param") // ?name=steve&age=20
    fun queryParam(
            @RequestParam(name = "name") name: String, 
            @RequestParam(value = "age") age:Int
            // 쿼리 파라미터로 들어온 값을 RequestParam으로 받을 수 있음
    ): String{ // 반환형
        println("${name} , ${age}")
        return name+" "+age
    }

    // 한 번에 객체로 받아서 처리하는 방법
    // 변수들을 하나로 감싸주는 클래스를 만들어야 함!
    // 리턴형이 object일 때 response가 ObjectMapper를 통해 json 형태로 바뀜
    // name, age, address, email
    // -
    // phoneNumber -> phonenumber , phone-number
    @GetMapping("/get-mapping/query-param/object")
    fun queryParamObject(userRequest: UserRequest): UserRequest {
        // 
        println(userRequest)
        return userRequest
    }


    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(@RequestParam map: Map<String,Any>): Map<String, Any> {
        println(map)
        val phoneNumber = map.get("phone-number")
        return map
    }

} 