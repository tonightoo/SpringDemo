package com.example.demo

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("hello")
class HelloController {
    //GetMappingに渡している値がルーティングのパス 今回の場合ルートパスにアクセスされるとindexが呼び出される
    @GetMapping("/world")
    fun index(model: Model): String {
        model.addAttribute("message", "Hello World!")
        return "index"
    }
}