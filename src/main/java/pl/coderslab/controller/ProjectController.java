package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.entity.Activity;
import pl.coderslab.entity.Project;
import pl.coderslab.entity.User;
import pl.coderslab.repository.ActivityRepository;
import pl.coderslab.repository.ProjectRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ActivityRepository activityRepository;


    @RequestMapping("/all")
    public String list(@RequestParam(required = false) String admin, Model model, HttpSession session) {
        String login = (String)session.getAttribute("login");
        if (login == null || login.equals("admin")) {
            model.addAttribute("projects", projectRepository.findAll());
        } else {
            User user = userRepository.findFirstByLogin(login);
            if (user != null) {
                model.addAttribute("projects", projectRepository.findByUsersContains(user));
            }
        }
        if (admin != null) {
            session.setAttribute("admin", admin);
        }
        return "project/list";
    }

    @RequestMapping("/form")
    public String showForm(@RequestParam(required = false) Long id, @RequestParam(required = false) String admin, Model model, HttpSession session){
        Project project = id == null ? new Project() : projectRepository.findFirstById(id);
        if (admin != null) {
            session.setAttribute("admin", admin);
        }
        model.addAttribute("project", project);
        return "project/form";
    }

    @RequestMapping(path = "/form", method = RequestMethod.POST)
    public String saveForm(@ModelAttribute @Valid Project project, BindingResult result, HttpSession session) { //@Valid
        if (result.hasErrors()) {
            return "project/form";
        }
        Project exProject = projectRepository.findFirstById(project.getId());
        projectRepository.save(project);
        if (exProject == null) {
            Activity activity = new Activity();
            activity.setActType(1);
            activity.setUser(userRepository.findFirstByLogin((String)session.getAttribute("login")));
            activity.setProject(project);
            activityRepository.save(activity);
        }
        return "redirect: all";
    }

    @ModelAttribute("users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @RequestMapping("/project")
    public String showDetails(@RequestParam(required = false) Long id, @RequestParam(required = false) String admin, Model model){
        Project project = id == null ? new Project() : projectRepository.findFirstById(id);
        model.addAttribute("admin", admin);
        model.addAttribute("project", project);
        return "project/project";
    }
}
