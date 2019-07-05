package pl.coderslab.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.validation.UserRegisterValidationGroup;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.groups.Default;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "login/register";
    }

    @PostMapping("/register")
    public String saveRegistrationForm(
            @Validated({UserRegisterValidationGroup.class, Default.class}) User user,
            BindingResult result,
            @RequestParam String password2) {
        if (result.hasErrors()) {
            return "login/register";
        }

        User existingUser = userRepository.findFirstByLogin(user.getLogin());
        if (existingUser != null) {
            result.addError(new FieldError("user", "email",
                    "Email already exists"));
            return "login/register";
        }
        //  String password = "password";
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        if (!BCrypt.checkpw(password2, hashed)) {
            result.addError(new FieldError("user", "password",
                    "Passwords do not match"));
            return "login/register";
        }

        userRepository.save(user);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login/login";
    }

    @PostMapping("/login")
    public String login(@Valid User user, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "login/login";
        }

        boolean loggedIn = true;
        User existingUser = userRepository.findFirstByLogin(user.getLogin());

        if (existingUser == null) {
            loggedIn = false;
        } else if (!BCrypt.checkpw(user.getPassword(), existingUser.getPassword())) {//(!user.getPassword().equals(existingUser.getPassword())) {
            loggedIn = false;
        }

        if (!loggedIn) {
            result.addError(new FieldError("user", "password",
                    "Incorrect email or password"));
            return "login/login";
        }

        session.setAttribute("login", user.getLogin());
        session.setAttribute("firstName", existingUser.getFirstName());

        return "redirect:/";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();

        return "redirect:/";
    }
}
