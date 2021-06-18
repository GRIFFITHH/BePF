package com.tis1.bepf.controller;

import com.tis1.bepf.memberDTO.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {

    @GetMapping("/register")
    public String register(Model model){
        MemberDTO memberDTO = new MemberDTO();
        model.addAttribute("user", memberDTO);
        return "register";
    }


}
