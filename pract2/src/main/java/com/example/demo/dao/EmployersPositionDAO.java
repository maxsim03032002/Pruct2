package com.example.demo.dao;

import com.example.demo.models.EmployersPosition;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployersPositionDAO {
    private static int EmployersPosition_COUNT;
    private List<EmployersPosition> employersPositions;
    {
        employersPositions = new ArrayList<>();
        Date date = new Date(1212121212121L);
        employersPositions.add(new EmployersPosition(0,"ВРАЧ", 34567, false, date, 34));
    }

    public List<EmployersPosition> index(){

        return employersPositions;
    }

    public EmployersPosition show(long id){
        return employersPositions.stream().filter(personModel -> personModel.getId() == id).findAny().orElse(null);
    }

    public void save(EmployersPosition people){
        people.setId(++EmployersPosition_COUNT);
        employersPositions.add(people);
    }

    public void update(long id, EmployersPosition personModel){
        EmployersPosition updatePerson = show(id);
        updatePerson.setPositionName(personModel.getPositionName());
        updatePerson.setBirthday(personModel.getBirthday());
        updatePerson.setWeight(personModel.getWeight());
        updatePerson.setGender(personModel.getGender());
    }


    public void delete(long id){
        employersPositions.removeIf(p-> p.getId() == id);
    }
}
