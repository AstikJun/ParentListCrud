package com.example.parentslistcrud.controller;

import com.example.parentslistcrud.entity.Parent;
import com.example.parentslistcrud.service.ParentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ParentController {

    private ParentService parentService;
    public ParentController(ParentService parentService) {
        super();
        this.parentService = parentService;
    }
    @GetMapping("/parents")
    public String listParents(Model model) {
        model.addAttribute("parents", parentService.getAllParents());
        return "parents";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/parents/new")
    public String createParentForm(Model model) {
        Parent parent = new Parent();
        model.addAttribute("parent", parent);
        return "create_parent";

    }

    @PostMapping("/parents")
    public String saveParent(@ModelAttribute("parent") Parent parent) {
        parentService.saveParent(parent);
        return "redirect:/parents";
    }

    @GetMapping("/parents/edit/{id}")
    public String editParentForm(@PathVariable Long id, Model model) {
        model.addAttribute("parent", parentService.getParentById(id));
        return "edit_parent";
    }

    @PostMapping("/parents/{id}")
    public String updateParent(@PathVariable Long id,
                            @ModelAttribute("parent") Parent parent,
                            Model model) {

        Parent existingParent = parentService.getParentById(id);
        existingParent.setId(id);
        existingParent.setFirstName(parent.getFirstName());
        existingParent.setLastName(parent.getLastName());
        existingParent.setEmail(parent.getEmail());
        existingParent.setChildName(parent.getChildName());

        parentService.updateParent(parent);
        return "redirect:/parents";
    }


    @GetMapping("/parents/{id}")
    public String deleteParentById(@PathVariable Long id) {
        parentService.deleteParentById(id);
        return "redirect:/parents";
    }
}
