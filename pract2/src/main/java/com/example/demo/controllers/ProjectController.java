package com.example.demo.controllers;

import com.example.demo.dao.ProjectDAO;
import com.example.demo.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class ProjectController {
    private ProjectDAO _projectDAO;

    @Autowired
    public ProjectController(ProjectDAO projectDAO){
        _projectDAO = projectDAO;
    }

    @GetMapping("/project")
    public String blogMain(Model model)
    {
        model.addAttribute("projects", _projectDAO.index());
        return "projects-main";
    }



    @PostMapping("/project/add")
    public String blogPostAdd(@RequestParam(defaultValue = "")  Date deadlines,
                              @RequestParam(defaultValue = "0") String description,
                              @RequestParam(defaultValue = "false")  float cost,
                              @RequestParam(defaultValue = "10.10.2010") String projectName,
                              @RequestParam(defaultValue = "0")  double employersCount,
                              Model model)
    {
        Project project = new Project(0, deadlines, description, cost,projectName,employersCount);
        _projectDAO.save(project);
        return "redirect:/project";
    }

    @GetMapping("/project/{id}/edit")
    public  String ProjectDetails(@PathVariable(value = "id") long id, Model model)
    {

        model.addAttribute("project",_projectDAO.show(id));
        if(_projectDAO.show(id) == null)
        {
            return  "redirect:/project";
        }
        return "projects-main";
    }


    @PostMapping ("/project/{id}/edit")
    public  String ProjectPostUpdate(@PathVariable(value = "id") long id,
                                     @RequestParam(defaultValue = "")  Date deadlines,
                                     @RequestParam(defaultValue = "0") String description,
                                     @RequestParam(defaultValue = "false")  float cost,
                                     @RequestParam(defaultValue = "10.10.2010") String projectName,
                                     @RequestParam(defaultValue = "0")  double employersCount,
                                     Model model)
    {
        Project project = _projectDAO.show(id);
        project.setDeadlines(deadlines);
        project.setDescription(description);
        project.setCost(cost);
        project.setProjectName(projectName);
        project.setEmployersCount(employersCount);
        _projectDAO.update(id,project);
        return "redirect:/project";
    }


    @GetMapping("/project/{id}/remove")
    public  String ProjectDelDetails(@PathVariable(value = "id") long id, Model model)
    {

        model.addAttribute("Project",_projectDAO.show(id));
        if(_projectDAO.show(id) == null)
        {
            return  "redirect:/project";
        }
        return ProjectDelete(id,model);
    }
    @PostMapping("/project/{id}/remove")
    public String ProjectDelete(@PathVariable(value = "id") long id, Model model){
        _projectDAO.delete(id);
        return "redirect:/project";
    }
}

