package controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import service.RegisterRequest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// hibernate validate 사용
@Deprecated
public class RegisterRequestValidator implements Validator {
    private static final String emailRegExp =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
            "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private Pattern pattern;

    public RegisterRequestValidator() {
        this.pattern = Pattern.compile(emailRegExp);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        // 검증 가능한 클래스인지 검사
        // validate 함수를 호출하기 전에 호출되어짐
        return RegisterRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        // 실제 유효성 검사 로직을 넣는 함수
        RegisterRequest regReq = (RegisterRequest) target;

        if (regReq.getEmail() == null || regReq.getEmail().trim().isEmpty()) {
            errors.rejectValue("email", "required");
        } else {
            Matcher matcher = pattern.matcher(regReq.getEmail());
            if(!matcher.matches()) {
                errors.rejectValue("email", "bad");
            }
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
        ValidationUtils.rejectIfEmpty(errors, "password", "required");
        ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "required");
        if (!regReq.getPassword().isEmpty()) {
            if (!regReq.isPasswordEqualToConfirmPassword()) {
                errors.rejectValue("confirmPassword", "noMatch");
            }
        }
    }
}
