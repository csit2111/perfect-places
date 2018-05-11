package com.csit2111.perfectplaces.service;

import com.csit2111.perfectplaces.model.PlaceType;

public interface PlaceTypeService {
    PlaceType addTag(PlaceType placeTag);
    void deleteTag(long id);
    PlaceType getTagByName(String name);
    PlaceType editTag(PlaceType tag);
}
