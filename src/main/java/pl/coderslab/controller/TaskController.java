package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.entity.*;
import pl.coderslab.repository.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    StatusRepository statusRepository;
    @Autowired
    PriorityRepository priorityRepository;
    @Autowired
    ActivityRepository activityRepository;

    @RequestMapping("/all")
    public String list(@RequestParam(required = false) Long projectId, Model model, HttpSession session) {
            String login = (String)session.getAttribute("login") == null ? new String() : (String)session.getAttribute("login");
            if (login.equals("admin")) {
                if (projectId == null)
                    model.addAttribute("tasks", taskRepository.findAll());
                else {
                    Project project = projectRepository.findFirstById(projectId);
                    model.addAttribute("tasks", taskRepository.findAllByProject_Id(projectId));
                }
            } else {
                User user = userRepository.findFirstByLogin(login);
                if (user != null) {
                    if (projectId == null) {
                        model.addAttribute("tasks", taskRepository.findByUser(user));
                    } else {
                        Project project = projectRepository.findFirstById(projectId);
                        model.addAttribute("tasks", taskRepository.findAllByProject_IdAndUser(projectId, user));
                    }
                }
            }

            return "task/list";
    }

    @RequestMapping("/form")
    public String showForm(@RequestParam(required = false) Long id, @RequestParam(required = false) Long projectId, Model model) {
        Task task = id == null ? new Task() : taskRepository.findFirstById(id);
        if (projectId != null) {
            Project proj = projectRepository.findFirstById(projectId);
            task.setProject(proj);
        }
        Project pr = task.getProject();
        if (pr != null) {
            model.addAttribute("users", userRepository.findAllByProjects(pr));
            List<Project> projectList = new ArrayList<>();
            projectList.add(pr);
            model.addAttribute("projects", projectList);
        } else {
            model.addAttribute("users", userRepository.findAll());
            model.addAttribute("projects", projectRepository.findAll());
        }
        model.addAttribute("task", task);

        return "task/form";
    }

    @RequestMapping(path = "/form", method = RequestMethod.POST)
    public String saveForm(@ModelAttribute @Valid Task task, BindingResult result, HttpSession session) { //@Valid
        if (result.hasErrors()) {
            return "task/form";
        }
        Task exTask = taskRepository.findFirstById(task.getId());
        taskRepository.save(task);
        if (exTask == null) {
            Activity activity = new Activity();
            Project project = projectRepository.findOne(task.getProject().getId());
            activity.setActType(2);
            activity.setUser(userRepository.findFirstByLogin((String)session.getAttribute("login")));
            activity.setProject(project);
            activity.setTask(task);
            activityRepository.save(activity);
        }
        Status st1 = exTask == null ? null : exTask.getStatus();
        Status st2 = task.getStatus();
        Long stId1 = st1 == null ? null : st1.getId();
        Long stId2 = st2 == null ? null : st2.getId();
        if (stId1 != stId2) {
            Activity activity = new Activity();
            Project project = projectRepository.findOne(task.getProject().getId());
            activity.setActType(3);
            activity.setUser(userRepository.findFirstByLogin((String)session.getAttribute("login")));
            activity.setProject(project);
            activity.setTask(task);
            activityRepository.save(activity);
        }
        return "redirect: all";
    }

    /* @ModelAttribute("users")
    public List<User> getUsers() {
        return userRepository.findAll();
    } */

    @ModelAttribute("stats")
    public List<Status> getStats() {
        return statusRepository.findByActive(true);
    }

    @ModelAttribute("priors")
    public List<Priority> getPriors() {
        return priorityRepository.findByActive(true);
    }

    /* @ModelAttribute("projects")
    public List<Project> getProjects() {
        return projectRepository.findAll();
    } */

    @RequestMapping("/task")
    public String showDetails(@RequestParam(required = false) Long id, Model model){
        Task task = id == null ? new Task() : taskRepository.findFirstById(id);
        model.addAttribute("task", task);
        return "task/task";
    }

    @RequestMapping(path = "/confirmDelete")
    public String confirmDelete() {
        return "task/confirmDelete";
    }

    @RequestMapping(path = "/delete")
    public String deleteUser(@RequestParam Long id, @RequestParam(required = false) String admin, @RequestParam(required = false) Long projectId) {
        taskRepository.delete(id);
        return "redirect: all";
    }

}
