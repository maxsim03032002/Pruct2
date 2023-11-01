package com.example.demo.dao;


import com.example.demo.models.PublishingHouse;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Component
public class PublishingDAO {
    private static int Publishing_COUNT;
    private List<PublishingHouse> publishingHouses;
    {
        publishingHouses = new ArrayList<>();
        publishingHouses.add(new PublishingHouse(0, "dfghjk", "dfghjkl", "134567", "adfg%567", 345));
    }

    public List<PublishingHouse> index(){

        return publishingHouses;
    }

    public PublishingHouse show(long id){
        return publishingHouses.stream().filter(personModel -> personModel.getId() == id).findAny().orElse(null);
    }

    public void save(PublishingHouse people){
        people.setId(++Publishing_COUNT);
        publishingHouses.add(people);
    }

    public void update(long id, PublishingHouse personModel){
        PublishingHouse updatePublishHous = show(id);
        updatePublishHous.setPublishName(personModel.getPublishName());
        updatePublishHous.setPublishAddress(personModel.getPublishAddress());
        updatePublishHous.setTelephoneNumber(personModel.getTelephoneNumber());
        updatePublishHous.setEmail(personModel.getEmail());
        updatePublishHous.setRating(personModel.getRating());
    }


    public void delete(long id){
        publishingHouses.removeIf(p-> p.getId() == id);
    }

    public PublishingHouse show(String searchString){
        return publishingHouses.stream().filter(personModel -> personModel.getPublishName() == searchString).findAny().orElse(null);
    }
}
