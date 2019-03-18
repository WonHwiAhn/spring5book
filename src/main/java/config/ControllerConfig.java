package config;

import controller.RegisterController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import service.MemberRegisterService;
import survey.SurveyController;

@Configuration
@ComponentScan(basePackages = {"controller", "service"})
public class ControllerConfig {
    @Autowired
    private MemberRegisterService memberRegisterService;

    @Bean
    public RegisterController registerController() {
        RegisterController controller = new RegisterController();
        // controller.setMemberRegisterService(memberRegisterService);
        return controller;
    }

    @Bean
    public SurveyController surveyController() {
        return new SurveyController();
    }
}
