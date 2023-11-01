package com.example.demo.controllers;

import com.example.demo.dao.EmployersPositionDAO;
import com.example.demo.dao.ProjectDAO;
import com.example.demo.models.EmployersPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class EmployersPositionController {
    private EmployersPositionDAO _employersPositionDAO;

    @Autowired
    public EmployersPositionController(EmployersPositionDAO projectDAO){
        _employersPositionDAO = projectDAO;
    }

    @GetMapping("/employersPosition")
    public String blogMain(Model model)
    {
        model.addAttribute("employersPositions", _employersPositionDAO.index());
        return "employers-position-main";
    }



    @PostMapping("/employersPosition/add")
    public String blogPostAdd(@RequestParam(defaultValue = "")  String positionName,
                              @RequestParam(defaultValue = "0") float salary,
                              @RequestParam(defaultValue = "false")  boolean gender,
                              @RequestParam(defaultValue = "10.10.2010") Date birthday,
                              @RequestParam(defaultValue = "0")  double weight,
                              Model model)
    {
        EmployersPosition employersPosition = new EmployersPosition(0, positionName, salary, gender,birthday,weight);
        _employersPositionDAO.save(employersPosition);
        return "redirect:/employersPosition";
    }



    @GetMapping("/employersPosition/{id}/edit")
    public  String EmployersPositionDetails(@PathVariable(value = "id") long id, Model model)
    {

        model.addAttribute("employersPosition",_employersPositionDAO.show(id));
        if(_employersPositionDAO.show(id) == null)
        {
            return  "redirect:/employersPosition";
        }
        return "employers-position-main";
    }


    @PostMapping ("/employersPosition/{id}/edit")
    public  String EmployersPositionPostUpdate(@PathVariable(value = "id") long id,
                                               @RequestParam(defaultValue = "")  String positionName,
                                               @RequestParam(defaultValue = "0") float salary,
                                               @RequestParam(defaultValue = "false")  boolean gender,
                                               @RequestParam(defaultValue = "10.10.2010") Date birthday,
                                               @RequestParam(defaultValue = "0")  double weight,
                                               Model model)
    {
        EmployersPosition employersPosition = _employersPositionDAO.show(id);
        employersPosition.setPositionName(positionName);
        employersPosition.setSalary(salary);
        employersPosition.setGender(gender);
        employersPosition.setBirthday(birthday);
        employersPosition.setWeight(weight);
        _employersPositionDAO.update(id, employersPosition);
        return "redirect:/employersPosition";
    }


    @GetMapping("/employersPosition/{id}/remove")
    public  String EmployersPositionDelDetails(@PathVariable(value = "id") long id, Model model)
    {

        model.addAttribute("employersPosition",_employersPositionDAO.show(id));
        if(_employersPositionDAO.show(id) == null)
        {
            return  "redirect:/employersPosition";
        }
        return EmployersPositionDelete(id,model);
    }
    @PostMapping("/employersPosition/{id}/remove")
    public String EmployersPositionDelete(@PathVariable(value = "id") long id, Model model){
        _employersPositionDAO.delete(id);
        return "redirect:/employersPosition";
    }
}

