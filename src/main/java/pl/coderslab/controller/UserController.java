package pl.coderslab.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Project;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.validation.UserRegisterValidationGroup;

import javax.validation.Valid;
import javax.validation.groups.Default;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/test")
    public String test(){
        return "redirect:/";
    }

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
        return "redirect:all";
    }

    @RequestMapping("/all")
    public String list(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "user/list";
    }

    @RequestMapping("/add")
    public String showForm(@RequestParam(required = false) Long id, Model model){
        User user = id == null ? new User() : userRepository.findFirstById(id);
        model.addAttribute("user", user);
        return "user/form";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String saveForm(@ModelAttribute @Valid User user, BindingResult result) { //@Valid
        if (result.hasErrors()) {
            return "user/form";
        }
        userRepository.save(user);
        return "redirect: all";
    }

    @RequestMapping(path = "/confirmDelete")
    public String confirmDelete() {
        return "user/confirmDelete";
    }

    @RequestMapping(path = "/delete")
    public String deleteUser(@RequestParam Long id) {
        userRepository.delete(id);
        return "redirect: all";
    }
}
