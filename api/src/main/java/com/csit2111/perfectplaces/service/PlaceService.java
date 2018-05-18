package com.csit2111.perfectplaces.service;

import com.csit2111.perfectplaces.model.Place;

import java.util.Collection;
import java.util.List;

public interface PlaceService {
    Place addPlace(Place place);
    void deletePlace(long id);
    Place getPlaceById(long id);
    Place editPlace(Place place);
    List<Place> getAll();
}
