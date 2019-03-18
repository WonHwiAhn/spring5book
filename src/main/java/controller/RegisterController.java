package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import exception.DuplicateMemberExeception;
import service.MemberRegisterService;
import service.RegisterRequest;

import javax.validation.Valid;

@Controller
@RequestMapping("register")
public class RegisterController {

    @Autowired
    private MemberRegisterService memberRegisterService;

    @RequestMapping(value = "step1", method = RequestMethod.GET)
    public String handleStep1() {
        return "register/step1";
    }

    @PostMapping("step2")
    public String handleStep2(@RequestParam(value="agree", defaultValue = "false")Boolean agree, Model model) {
        if(!agree) {
            return "register/step1";
        }
        model.addAttribute("registerRequest", new RegisterRequest());
        return "register/step2";
    }

    @PostMapping("step3")
    public String handlerStep3(@ModelAttribute("registerRequest") @Valid RegisterRequest reqReq, Errors errors) {
        // @Valid를 사용함으로써 아래의 줄이 필요없어짐 (mvcConfig에 validator를 등록해야 사용가능함)
        // new RegisterRequestValidator().validate(reqReq, errors);

        if(errors.hasErrors())
            return "register/step2";

        try {
            memberRegisterService.regist(reqReq);
            return "register/step3";
        } catch (DuplicateMemberExeception e) {
            return "register/step2";
        }
    }

    // hibernate validator 사용으로 안씀
    // @Valid가 호출될 때 이놈을 먼저 bind하게됨됨
    /*@Deprecated
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new RegisterRequestValidator());
    }*/
}
