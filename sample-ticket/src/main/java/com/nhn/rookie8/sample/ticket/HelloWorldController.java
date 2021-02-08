package com.nhn.rookie8.sample.ticket;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class HelloWorldController {

    @Value("${application.message:Hello World}")
    private String message = "Hello Rookie";

    @GetMapping("/")
    public String welcome(Model model) {
        model.addAttribute("time", new Date());
        model.addAttribute("message", this.message);
        return "welcome";
    }

    @GetMapping("/helloworld")
    @ResponseBody // 메시지 컨버터를 통해서 json, html 등으로(미디어 타입) 반환한다.
    public String helloworld() {
        return "Hello Rookie!!"; // Plain Text로 반환됨
    }

}
