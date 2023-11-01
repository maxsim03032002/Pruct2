package com.example.demo.dao;

import com.example.demo.models.Post;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Component
public class PostDAO {
    private static int Human_COUNT;
    private List<Post> human;
    {
        human = new ArrayList<>();
        Date date = new Date(1212121212121L);
        human.add(new Post(0,3456, false, "qwertyuhgfdsfghjkkjbvxvbjnhbgfd", date, 34));
    }

    public List<Post> index(){

        return human;
    }

    public Post show(long id){
        return human.stream().filter(personModel -> personModel.getId() == id).findAny().orElse(null);
    }

    public void save(Post people){
        people.setId(++Human_COUNT);
        human.add(people);
    }

    public void update(long id, Post personModel){
        Post updatePerson = show(id);
        updatePerson.setTitle(personModel.getTitle());
        updatePerson.setAnons(personModel.getAnons());
        updatePerson.setFull_text(personModel.getFull_text());
        updatePerson.setDateAnons(personModel.getDateAnons());
        updatePerson.setCountReaders(personModel.getCountReaders());
    }


    public void delete(long id){
        human.removeIf(p-> p.getId() == id);
    }
}
