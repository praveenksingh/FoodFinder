package com.findmefood.googleplace;


import com.findmefood.model.RestaurantDetails;
import org.springframework.stereotype.Component;
import se.walkercrou.places.GooglePlaces;
import se.walkercrou.places.Param;
import se.walkercrou.places.Place;

import java.util.ArrayList;
import java.util.List;

@Component
public class GooglePlaceFinder {

    private GooglePlaces client = new GooglePlaces("AIzaSyAGHTEDVrk4tz7QSEQnC62uMyDhORz0Hjs");
    public List<RestaurantDetails> getResults(String query, String location) {
        List<Place> places = client.getPlacesByQuery(query, GooglePlaces.MAXIMUM_PAGE_RESULTS,
                Param.name("language").value("en"),
                Param.name("opennow").value(true),
                Param.name("type").value("restaurant"),
                Param.name("location").value(location),
                Param.name("radius").value("1000"));
//                Param.name("rankby").value("distance"));
        List<RestaurantDetails> lis = new ArrayList<>();
        for (int i=0;i<3;i++) {
            lis.add(new RestaurantDetails(places.get(i).getName(),
                    places.get(i).getAddress(),
                    places.get(i).getPhoneNumber()));
        }
        return lis;
    }

}
