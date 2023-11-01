package com.example.demo.controllers;


import com.example.demo.dao.PublishingDAO;
import com.example.demo.models.EmployersPosition;
import com.example.demo.models.Project;
import com.example.demo.models.PublishingHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class PublishingController {
    private PublishingDAO _publishingDAO;

    @Autowired
    public PublishingController(PublishingDAO publishingDAO){
        _publishingDAO = publishingDAO;
    }

    @GetMapping("/publishingHouse")
    public String blogMain(Model model)
    {
        model.addAttribute("publishingHouses", _publishingDAO.index());
        return "publish-house-main";
    }



    @PostMapping("/publishingHouse/add")
    public String blogPostAdd(@RequestParam(defaultValue = "")  String publishName,
                              @RequestParam(defaultValue = "0") String publishAddress,
                              @RequestParam(defaultValue = "false")  String telephoneNumber,
                              @RequestParam(defaultValue = "10.10.2010") String email,
                              @RequestParam(defaultValue = "0")  double rating,
                              Model model)
    {
        PublishingHouse publishingHouse = new PublishingHouse(0, publishName, publishAddress, telephoneNumber,email,rating);
        _publishingDAO.save(publishingHouse);
        return "redirect:/publishingHouse";
    }

    @GetMapping("/publishingHouse/{id}/edit")
    public  String PublishingHouseDetails(@PathVariable(value = "id") long id, Model model)
    {
        model.addAttribute("publishingHouse",_publishingDAO.show(id));
        if(_publishingDAO.show(id) == null)
        {
            return  "redirect:/publishingHouse";
        }
        return "publish-house-main";
    }


    @PostMapping ("/publishingHouse/{id}/edit")
    public  String PublishingHousePostUpString(@PathVariable(value = "id") long id,
                                               @RequestParam(defaultValue = "")  String publishName,
                                               @RequestParam(defaultValue = "0") String publishAddress,
                                               @RequestParam(defaultValue = "false")  String telephoneNumber,
                                               @RequestParam(defaultValue = "10.10.2010") String email,
                                               @RequestParam(defaultValue = "0")  double rating,
                                               Model model)
    {
        PublishingHouse publishingHouse = _publishingDAO.show(id);
        publishingHouse.setPublishName(publishName);
        publishingHouse.setPublishAddress(publishAddress);
        publishingHouse.setTelephoneNumber(telephoneNumber);
        publishingHouse.setEmail(email);
        publishingHouse.setRating(rating);
        _publishingDAO.update(id,publishingHouse);
        return "redirect:/publishingHouse";
    }


    @GetMapping("/publishingHouse/{id}/remove")
    public  String PublishingHouseDelDetails(@PathVariable(value = "id") long id, Model model)
    {
        model.addAttribute("publishingHouse",_publishingDAO.show(id));
        if(_publishingDAO.show(id) == null)
        {
            return  "redirect:/publishingHouse";
        }
        return PublishingHouseDelete(id,model);
    }
    @PostMapping("/publishingHouse/{id}/remove")
    public String PublishingHouseDelete(@PathVariable(value = "id") long id, Model model){
        _publishingDAO.delete(id);
        return "redirect:/publishingHouse";
    }


}

