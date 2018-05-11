package com.csit2111.perfectplaces.service;

import com.csit2111.perfectplaces.model.Region;

public interface RegionService {
    Region addRegion(Region region);
    void deleteRegion(long id);
    Region editRegion(Region region);
}
