package com.tis1.bepf.controller;

import com.tis1.bepf.project.Project;
import com.tis1.bepf.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BoardController {

    private final ProjectService projectService;

    @Autowired
    public BoardController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/board")
    public String board(Model model){
        List<Project> projects = projectService.findAllProjects();
        model.addAttribute("projects", projects);
        return "board";
    }
}
