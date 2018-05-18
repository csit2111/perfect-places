package com.csit2111.perfectplaces.service.impl;

import com.csit2111.perfectplaces.model.Place;
import com.csit2111.perfectplaces.repository.PlaceRepository;
import com.csit2111.perfectplaces.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    @Override
    public Place getPlaceById(long id) {
        List<Long> ids = new ArrayList<>();
        ids.add(id);
        List<Place> places = placeRepository.findAllById(ids);
        if (places.isEmpty())
            return new Place();
        return places.get(0);
    }

    @Override
    public Place editPlace(Place place) {
        return placeRepository.saveAndFlush(place);
    }

    @Override
    public List<Place> getAll() {
        Collection<Place> t = placeRepository.findAll();
        return placeRepository.findAll();
    }
}
