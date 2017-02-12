package com.findmefood.googleplace;


import com.findmefood.model.RestaurantDetails;
import net.sf.sprockets.google.Place;
import net.sf.sprockets.google.Places;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class FoodPlaceFinder {

    public List<RestaurantDetails> getResults(String query, String lat, String lon) throws IOException {
        List<Place> places;
        places = Places.nearbySearch(Places.Params.create()
                        .latitude(Double.parseDouble(lat)).longitude(Double.parseDouble(lon)).radius(5000)
                        .keyword(query).openNow(true).maxResults(3)).getResult();
        List<RestaurantDetails> lis = new ArrayList<>();
        for (int i=0;i< (3 < places.size() ? 3 : places.size());i++) {
            lis.add(new RestaurantDetails(places.get(i).getName(),
                    places.get(i).getVicinity(),
                    places.get(i).getFormattedPhoneNumber()));
        }
        return lis;
    }

}
