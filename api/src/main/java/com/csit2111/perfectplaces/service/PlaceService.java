package com.csit2111.perfectplaces.service;

import com.csit2111.perfectplaces.model.Place;

import java.util.Collection;

public interface PlaceService {
    Place addPlace(Place place);
    void deletePlace(long id);
   // Place getPlaceByName(String name);
    Place editPlace(Place place);
    Collection<Place>getAll();
}
