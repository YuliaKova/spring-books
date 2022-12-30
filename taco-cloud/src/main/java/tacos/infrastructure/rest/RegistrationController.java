package tacos.infrastructure.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tacos.application.service.RegistrationService;
import tacos.domain.entity.User;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @GetMapping
    public String registerForm() {
        return "registration";
    }

    @PostMapping
    public String processRegistration(User user) {
        registrationService.save(user);
        return "redirect:/login";
    }
}
