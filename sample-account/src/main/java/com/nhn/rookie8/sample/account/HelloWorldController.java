package com.nhn.rookie8.sample.account;

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
    @ResponseBody
    public String welcome(Model model) {
        model.addAttribute("time", new Date());
        model.addAttribute("message", this.message);
        return "welcome";
    }

    @GetMapping("/account/helloworld2")
    @ResponseBody
    public String helloworld2() {
        return "Hello world! Hello NamYunWon!!!!!!";
    }

}
