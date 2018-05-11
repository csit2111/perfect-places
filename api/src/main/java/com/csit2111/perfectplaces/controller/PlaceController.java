package com.csit2111.perfectplaces.controller;

import com.csit2111.perfectplaces.model.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class PlaceController {

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

}
