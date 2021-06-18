package com.tis1.bepf.controller;

import com.tis1.bepf.registration.UserAlreadyExistException;
import com.tis1.bepf.member.Member;
import com.tis1.bepf.member.MemberDTO;
import com.tis1.bepf.member.MemberService;
import com.tis1.bepf.registration.OnRegistrationCompleteEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@Controller
public class RegisterController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private ApplicationEventPublisher eventPublisher;

    private MessageSource messages;

    private MemberService memberService;

    @GetMapping("/register")
    public String register(Model model){
        MemberDTO memberDTO = new MemberDTO();
        model.addAttribute("member", memberDTO);
        return "register";
    }

    @PostMapping("/register")
    public ModelAndView registerUserAccount(@ModelAttribute("member") @Valid final MemberDTO memberDTO,
                                            final HttpServletRequest request, final Errors errors) {
        LOGGER.debug("Registering member account with information: {}", memberDTO);

        try {
            final Member registered = memberService.registerAccount(memberDTO);

            final String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
            eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered, request.getLocale(), appUrl));
        } catch (final UserAlreadyExistException uaeEx) {
            ModelAndView mav = new ModelAndView("registration", "member", memberDTO);
            String errMessage = messages.getMessage("message.regError", null, request.getLocale());
            mav.addObject("message", errMessage);
            return mav;
        } catch (final RuntimeException ex) {
            LOGGER.warn("Unable to register member", ex);
            return new ModelAndView("emailError", "member", memberDTO);
        }
        return new ModelAndView("successRegister", "member", memberDTO);
    }
}
