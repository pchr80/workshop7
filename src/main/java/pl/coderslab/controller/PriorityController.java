package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.entity.Priority;
import pl.coderslab.repository.PriorityRepository;
import pl.coderslab.repository.UserRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/priority")
public class PriorityController {

    @Autowired
    PriorityRepository priorityRepository;
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/all")
    public String list(Model model) {
        model.addAttribute("priors", priorityRepository.findAll());
        return "priority/list";
    }

    @RequestMapping("/form")
    public String showForm(@RequestParam(required = false) Long id, Model model){
        Priority priority = id == null ? new Priority() : priorityRepository.findFirstById(id);
        model.addAttribute("priority", priority);
        return "priority/form";
    }

    @RequestMapping(path = "/form", method = RequestMethod.POST)
    public String saveForm(@ModelAttribute @Valid Priority priority, BindingResult result) { //@Valid
        if (result.hasErrors()) {
            return "priority/form";
        }
        priorityRepository.save(priority);
        return "redirect: all";
    }

    @RequestMapping(path = "/confirmDelete")
    public String confirmDelete() {
        return "priority/confirmDelete";
    }

    @RequestMapping(path = "/delete")
    public String deleteUser(@RequestParam Long id) {
        priorityRepository.delete(id);
        return "redirect:all";
    }

    @RequestMapping("/details")
    public String showDetails(@RequestParam(required = false) Long id, Model model){
        Priority priority = id == null ? new Priority() : priorityRepository.findFirstById(id);
        model.addAttribute("priority", priority);
        return "priority/details";
    }
}

