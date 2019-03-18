package controller;

import Validator.ChangePwdCommandValidator;
import command.ChangePwdCommand;
import exception.WrongIdPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.AuthInfo;
import service.ChangePasswordService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("edit")
public class ChangePwdController {
    @Autowired
    private ChangePasswordService changePasswordService;

    @GetMapping("changePassword")
    public void form(@ModelAttribute("command") ChangePwdCommand pwdCommand) {}

    @PostMapping("changePassword")
    public String submit(@ModelAttribute("command") ChangePwdCommand pwdCommand, Errors errors, HttpSession session) {
        new ChangePwdCommandValidator().validate(pwdCommand, errors);

        if(errors.hasErrors()) {
            return "edit/changePassword";
        }

        AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");

        try {
            changePasswordService.changepPassword(authInfo.getEmail(), pwdCommand.getCurrentPassword(), pwdCommand.getNewPassword());
            return "edit/changedPwd";
        } catch (WrongIdPasswordException e) {
            errors.rejectValue("currentPassword", "notMatching");
            return "edit/changePassword";
        }
    }
}
