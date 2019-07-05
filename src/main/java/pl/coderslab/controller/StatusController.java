package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.entity.Status;
import pl.coderslab.entity.User;
import pl.coderslab.repository.StatusRepository;
import pl.coderslab.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/status")
public class StatusController {

    @Autowired
    StatusRepository statusRepository;
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/all")
    public String list(Model model) {
        model.addAttribute("stats", statusRepository.findAll());
        return "status/list";
    }

    @RequestMapping("/form")
    public String showForm(@RequestParam(required = false) Long id, Model model){
        Status status = id == null ? new Status() : statusRepository.findFirstById(id);
        model.addAttribute("status", status);
        return "status/form";
    }

    @RequestMapping(path = "/form", method = RequestMethod.POST)
    public String saveForm(@ModelAttribute @Valid Status status, BindingResult result) { //@Valid
        if (result.hasErrors()) {
            return "status/form";
        }
        statusRepository.save(status);
        return "redirect: all";
    }

    @RequestMapping(path = "/confirmDelete")
    public String confirmDelete() {
        return "status/confirmDelete";
    }

    @RequestMapping(path = "/delete")
    public String deleteUser(@RequestParam Long id) {
        statusRepository.delete(id);
        return "redirect:all";
    }

    @RequestMapping("/details")
    public String showDetails(@RequestParam(required = false) Long id, Model model){
        Status status = id == null ? new Status() : statusRepository.findFirstById(id);
        model.addAttribute("status", status);
        return "status/details";
    }
}
