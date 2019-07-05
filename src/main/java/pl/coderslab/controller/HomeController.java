package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.User;
import pl.coderslab.repository.ActivityRepository;
import pl.coderslab.repository.ProjectRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ActivityRepository activityRepository;

    @RequestMapping("/")
    public String home(Model model, HttpSession session) {
        String login = (String)session.getAttribute("login");
        if (login != null) {
        if (login.equals("admin")) {
            model.addAttribute("projects", projectRepository.findFirst5ByOrderByDateCreatedDesc());
        } else if (!login.isEmpty()) {
            User user = userRepository.findFirstByLogin(login);
            if (user != null) {
                model.addAttribute("projects", projectRepository.findFirst5ByUsersContainsOrderByDateCreatedDesc(user));
            }
        } }
        if (login != null) {
            if (login.equals("admin")) {
                model.addAttribute("activities", activityRepository.findFirst25ByOrderByActDateDesc());
            } else if (!login.isEmpty()) {
                User user = userRepository.findFirstByLogin(login);
                if (user != null) {
                    model.addAttribute("activities", activityRepository.findFirst25ByUserOrderByActDateDesc(user));
                }
            } }
        return "home/index";
    }

    @RequestMapping("/adm")
    public String admin() {
        return "home/admin";
    }

}
