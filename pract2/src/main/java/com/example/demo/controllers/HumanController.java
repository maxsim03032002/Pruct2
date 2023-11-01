package com.example.demo.controllers;

import com.example.demo.dao.HumanDAO;
import com.example.demo.models.Human;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;


@Controller
public class HumanController {

    private HumanDAO _humanDAO;

    @Autowired
    public HumanController(HumanDAO humanDAO){
        _humanDAO = humanDAO;
    }

    @GetMapping("/human")
    public String blogMain(Model model)
    {
        model.addAttribute("humans", _humanDAO.index());
        return "human-main";
    }



    @PostMapping("/human/add")
    public String blogPostAdd(@RequestParam(defaultValue = "")  String lastName,
                              @RequestParam(defaultValue = "0") float height,
                              @RequestParam(defaultValue = "false")  boolean gender,
                              @RequestParam(defaultValue = "10.10.2010") Date birthday,
                              @RequestParam(defaultValue = "0")  double weight,
                              Model model)
    {
        /*try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
            String dateStr = sdf.format(date);
            Date parseDate = sdf.parse(birthday);
            Human newHuman = new Human(0,lastName, height, gender,parseDate,weight);
            _humanDAO.save(newHuman);
        } catch (java.text.ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        Human newHuman = new Human(0,lastName, height, gender,birthday,weight);
        _humanDAO.save(newHuman);
        //humanRepository.save(human);

        return "redirect:/human";
    }

    /*@PostMapping("/human/filter")
    public String blogResult(@RequestParam(defaultValue = "") String lastName, Model model)
    {
       List<Human> result = humanRepository.findByLastNameContains(lastName);
        //List<Human> result = humanRepository.findByWeightContains(weight);
        model.addAttribute("result", result);
        return "human-main";
    }*/


    @GetMapping("/human/{id}/edit")
    public  String HumanDetails(@PathVariable(value = "id") int id, Model model)
    {
        /*Optional<Human> post = humanRepository.findById(id);
        ArrayList<Human> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("human",res);
        if(!humanRepository.existsById(id))
        {
            return  "redirect:/human";
        }
        return "human-main";*/
        model.addAttribute("human",_humanDAO.show(id));
        if(_humanDAO.show(id) == null)
        {
            return  "redirect:/human";
        }
        return "human-main";
    }


    @PostMapping ("/human/{id}/edit")
    public  String HumanPostUpdate(@PathVariable(value = "id") int id,
                                  @RequestParam(defaultValue = "")  String lastName,
                                  @RequestParam(defaultValue = "0") float height,
                                  @RequestParam(defaultValue = "false")  boolean gender,
                                  @RequestParam(defaultValue = "10.10.2010") Date birthday,
                                  @RequestParam(defaultValue = "0")  double weight,
                                  Model model)
    {
        Human human = _humanDAO.show(id);
        human.setId(id);
        human.setLastName(lastName);
        human.setHeight(height);
        human.setGender(gender);
        human.setBirthday(birthday);
        human.setWeight(weight);
        _humanDAO.update(id,human);
        return "redirect:/human";
    }


    @GetMapping("/human/{id}/remove")
    public  String HumanDelDetails(@PathVariable(value = "id") int id, Model model)
    {
        /*Optional<Human> post = humanRepository.findById(id);
        ArrayList<Human> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("human",res);
        if(!humanRepository.existsById(id))
        {
            return  "redirect:/human";
        }
        return HumanDelete(id,model);*/

        model.addAttribute("human",_humanDAO.show(id));
        if(_humanDAO.show(id) == null)
        {
            return  "redirect:/human";
        }
        return HumanDelete(id,model);

    }
    @PostMapping("/human/{id}/remove")
    public String HumanDelete(@PathVariable(value = "id") int id, Model model){
        /*Human human = humanRepository.findById(id).orElseThrow();
        humanRepository.delete(human);
        return "redirect:/human";*/
        _humanDAO.delete(id);
        return "redirect:/human";
    }
}
