package com.example.demo.controllers;

import com.example.demo.dao.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class BlogController  {
    private PostDAO _postDAO;

    @Autowired
    public BlogController(PostDAO postDAO){
        _postDAO = postDAO;
    }


    @GetMapping("/")
    public String blogMain(Model model)
    {
        model.addAttribute("posts", _postDAO.index());
        return "blog-main";
    }

   @GetMapping("/blog/add")
    public String blogAdd(Model model)
    {
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String blogPostAdd(@RequestParam(defaultValue = "0")  double title,
                              @RequestParam(defaultValue = "false") boolean anons,
                              @RequestParam(defaultValue = "non")  String full_text,
                              @RequestParam(defaultValue = "10.10.2010")  Date dateAnons,
                              @RequestParam(defaultValue = "0")  int countReaders,
                              Model model)
    {
        Post post = new Post(0, title, anons, full_text,dateAnons,countReaders);
        _postDAO.save(post);
        return "redirect:/";
    }


    @GetMapping("/blog/{id}")
    public  String blogDetails(@PathVariable(value = "id") long id, Model model)
    {
        model.addAttribute("post", _postDAO.show(id));
        if(_postDAO.show(id) == null)
        {
            return  "redirect:/blog";
        }
        return "blog-details";
    }


    @GetMapping("/blog/{id}/edit")
    public  String blogEdit(@PathVariable(value = "id") long id, Model model)
    {
        if(_postDAO.show(id) == null)
        {
            return  "redirect:/blog";
        }
        model.addAttribute("post", _postDAO.show(id));
        return "blog-edit";
    }


    @PostMapping ("/blog/{id}/edit")
    public  String blogPostUpdate(@PathVariable(value = "id") long id,
                                  @RequestParam(defaultValue = "0")  double title,
                                  @RequestParam(defaultValue = "false") boolean anons,
                                  @RequestParam(defaultValue = "non")  String full_text,
                                  @RequestParam(defaultValue = "10.10.2010")  Date dateAnons,
                                  @RequestParam(defaultValue = "0")  int countReaders,
                                  Model model)
    {
        Post post = _postDAO.show(id);
        post.setTitle(title);
        post.setAnons(anons);
        post.setFull_text(full_text);
        post.setDateAnons(dateAnons);
        post.setCountReaders(countReaders);
        _postDAO.update(id,post);
        return "redirect:/";
    }


    @PostMapping("/blog/{id}/remove")
    public String blogBlogDelete(@PathVariable(value = "id") long id, Model model){
        _postDAO.delete(id);
        return "redirect:/";
    }


}
