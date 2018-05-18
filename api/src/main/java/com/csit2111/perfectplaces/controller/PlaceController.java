package com.csit2111.perfectplaces.controller;

import com.csit2111.perfectplaces.model.*;
import com.csit2111.perfectplaces.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
//@RequestMapping(value = "/v1/place")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public @ResponseBody Place getPlace()
    {
        Place place = new Place();
        place.setName("Площадь Кирова");
        place.setDescription("Это центр нашей Вселенной. С него всё началось и в нём всё закончится!");
        place.setId(1);
        Region region = new Region("Саратовская область");
        region.setId(64);
        place.setRegionId(region);
        PlaceTag tag = new PlaceTag();
        place.setTagId(tag);
        place.setLatitude(51.5332f);
        place.setLongitude(46.0192f);
        place.setContacts("ул. Кирова, д. 8");
        Collection<Photo> p = new ArrayList<Photo>();
        Photo photo = new Photo("https://turisticum.ru/img/saratov_1/881_2.jpg");
        p.add(photo);
        place.setPhotos(p);
        Collection<Comment> comments = new ArrayList<Comment>();
        place.setComments(comments);
        return place;
    }

    @RequestMapping(value = "/v1/place", params = "id", method = RequestMethod.GET)
    public @ResponseBody Place getPlcaeById(@RequestParam("id") long id)
    {
        Place place = placeService.getPlace(id);
        return place;
    }
}
