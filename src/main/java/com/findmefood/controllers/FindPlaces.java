package com.findmefood.controllers;

import com.findmefood.googleplace.GooglePlaceFinder;
import com.findmefood.model.RestaurantDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FindPlaces {

    private final GooglePlaceFinder googlePlaceFinder;

    @Autowired
    public FindPlaces(GooglePlaceFinder googlePlaceFinder) {
        this.googlePlaceFinder = googlePlaceFinder;
    }

    @RequestMapping("/foodplaces")
    public List<RestaurantDetails> greeting(@RequestParam(value="name", defaultValue="Restaurant") String name,
                                            @RequestParam(value="lat", defaultValue="42.3385905") String lat,
                                            @RequestParam (value="lat", defaultValue="-71.0920237") String lon){
        return googlePlaceFinder.getResults(name, lat+","+lon);
    }
}
