package com.csit2111.perfectplaces.controller;

import com.csit2111.perfectplaces.model.*;
import com.csit2111.perfectplaces.service.CommentService;
import com.csit2111.perfectplaces.service.PlaceService;
import com.csit2111.perfectplaces.service.UserService;
import com.csit2111.perfectplaces.service.impl.PlaceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Place> getAllPlaces() {
        return placeService.getAll();
    }

    @RequestMapping(value = "/places/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Place getPlaceById(@PathVariable long id) {
        return placeService.getPlaceById(id);
    }

    @RequestMapping(value = "/places/{id}", method = RequestMethod.POST)
    public @ResponseBody Comment getPlaceById(@PathVariable long id, @RequestBody Comment comment) {
        comment.setId(0);
        comment.setPlace(getPlaceById(id));
        comment.setUser(userService.getUserById(1));
        comment = commentService.addComment(comment);
        return comment;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public @ResponseBody Place getPlace()
    {
        Place place = new Place();
        place.setName("Площадь Кирова");
        place.setDescription("Это центр нашей Вселенной. С него всё началось и в нём всё закончится!");
        place.setId(1);
        Region region = new Region("Саратовская область");
        region.setId(64);
        place.setRegion(region);
        PlaceTag tag = new PlaceTag();
        place.setTag(tag);
        place.setLatitude(51.5332f);
        place.setLongitude(46.0192f);
        place.setContacts("ул. Кирова, д. 8");
        Collection<Photo> p = new ArrayList<Photo>();
        Photo photo = new Photo();
        p.add(photo);
        place.setPhotos(p);
        Collection<Comment> comments = new ArrayList<Comment>();
        place.setComments(comments);
        return place;
    }

}
