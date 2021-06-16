package com.tis1.bepf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String index(Model model){
//        model.addAttribute("eventName", "EVENT");
        //광훈 수정 테스트
        return "index";
    }
}
