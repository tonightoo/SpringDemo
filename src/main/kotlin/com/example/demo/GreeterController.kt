package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("greeter")
class GreeterController(@Qualifier("EnglishMessageService") private val messageService: MessageService) {

    private lateinit var greeter: Greeter

    @GetMapping("/hello")
    fun hello(@RequestParam("name") name: String) : HelloResponse {
        return HelloResponse("Hello $name")
    }

    @GetMapping("/hello/{name}")
    fun helloPathValue(@PathVariable("name") name: String): HelloResponse {
        return HelloResponse("Hello $name")
    }

    @PostMapping("/hello")
    fun helloByPost(@RequestBody request: HelloRequest): HelloResponse {
        return HelloResponse("Hello ${request.name}")
    }

    @GetMapping("/hello/byservice/{name}")
    fun helloByServiec(@PathVariable("name") name: String): HelloResponse {
        val message = greeter.sayHello(name)
        return HelloResponse(message)
    }



}

data class HelloResponse(val message: String)

data class HelloRequest(val name: String)