package com.csit2111.perfectplaces.service.impl;

import com.csit2111.perfectplaces.model.Place;
import com.csit2111.perfectplaces.repository.PlaceRepository;
import com.csit2111.perfectplaces.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceRepository placeRepository;


    @Override
    public Place addPlace(Place place) {
        Place place1 = placeRepository.saveAndFlush(place);
        return place1;
    }

    @Override
    public void deletePlace(long id) {
        placeRepository.deleteById(id);
    }

    /*@Override
    public Place getPlaceByName(String name) {
       return placeRepository.findPlaceByName(name);
    }*/

    public Place getPlace(long id)
    {
        return  placeRepository.getOne(id);
    }

    @Override
    public Place editPlace(Place place) {
        return placeRepository.saveAndFlush(place);
    }

    @Override
    public Collection<Place> getAll() {
        return placeRepository.findAll();
    }
}
