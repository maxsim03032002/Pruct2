package com.example.demo.dao;

import com.example.demo.models.Human;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class HumanDAO {

    private static int Human_COUNT;
    private List<Human> human;
    {
        human = new ArrayList<>();
        Date date = new Date(1212121212121L);
        human.add(new Human(0,"Петров", 136, false, date, 34));
    }

    public List<Human> index(){

        return human;
    }

    public Human show(long id){
        return human.stream().filter(personModel -> personModel.getId() == id).findAny().orElse(null);
    }

    public void save(Human people){
        people.setId(++Human_COUNT);
        human.add(people);
    }

    public void update(long id, Human personModel){
        Human updatePerson = show(id);
        updatePerson.setLastName(personModel.getLastName());
        updatePerson.setBirthday(personModel.getBirthday());
        updatePerson.setWeight(personModel.getWeight());
        updatePerson.setGender(personModel.getGender());
    }


    public void delete(long id){
        human.removeIf(p-> p.getId() == id);
    }
    
    

}
