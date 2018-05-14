package com.csit2111.perfectplaces.service;

import com.csit2111.perfectplaces.model.PlaceTag;

public interface PlaceTagService {
    PlaceTag addTag(PlaceTag placeTag);
    void deleteTag(long id);
    PlaceTag getTagByName(String name);
    PlaceTag editTag(PlaceTag tag);
}
