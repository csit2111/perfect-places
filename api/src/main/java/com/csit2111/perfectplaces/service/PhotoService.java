package com.csit2111.perfectplaces.service;

import com.csit2111.perfectplaces.model.Photo;

public interface PhotoService {
    Photo addPhoto(Photo photo);
    void deltePhoto(long id);
    Photo editPhoto(Photo photo);
}
