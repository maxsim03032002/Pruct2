package com.example.demo.dao;

import com.example.demo.models.Project;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectDAO {
    private static int Project_COUNT;
    private List<Project> project;
    {
        project = new ArrayList<>();
        Date date = new Date(1212121212121L);
        project.add(new Project(0,date, "Учебная практика", 3500, "ПРАКТИЧЕСКАЯ 2",34));
    }

    public List<Project> index(){

        return project;
    }

    public Project show(long id){
        return project.stream().filter(personModel -> personModel.getId() == id).findAny().orElse(null);
    }

    public void save(Project people){
        people.setId(++Project_COUNT);
        project.add(people);
    }

    public void update(long id, Project personModel){
        Project updateProject = show(id);
        updateProject.setDeadlines(personModel.getDeadlines());
        updateProject.setDescription(personModel.getDescription());
        updateProject.setCost(personModel.getCost());
        updateProject.setProjectName(personModel.getProjectName());
        updateProject.setEmployersCount(personModel.getEmployersCount());
    }


    public void delete(long id){
        project.removeIf(p-> p.getId() == id);
    }
}
