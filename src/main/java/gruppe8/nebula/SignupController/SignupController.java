package gruppe8.nebula.SignupController;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class SignupController {
    private final SignupService signupService;
    private final Logger logger;

    public SignupController(SignupService registrationService) {
        this.signupService = registrationService;
        this.logger = LoggerFactory.getLogger(this.getClass());
    }

    @GetMapping("/signup")
    public String signup(@RequestParam Optional<String> error, Model model) {
        if (error.isPresent()) {
            model.addAttribute("error", true);
        }
        return "signup";
    }

    @PostMapping("/signup")
    public String addUser(SignupRequest request) {
        logger.info("Received SignupRequest");
        Boolean success = signupService.register(request);

        if (success) {
            logger.info("Successful signup");
            return "redirect:/login?signupSuccess";
        }

        logger.info("Unsuccessful signup");
        return "redirect:/signup?error";
    }

}
