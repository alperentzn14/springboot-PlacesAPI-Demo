package test.example.Testdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import test.example.Testdemo.Model.Response;

@RestController
public class Geocoder {

    private static final Object API_KEY ="********************";
    private static final  Object location ="42.3675294%2C-71.186966";
    private static  final Object radius =15;


    /*
https://maps.googleapis.com/maps/api/place/nearbysearch/json
?key=******************&location=42.3675294%2C-71.186966&radius=15
     */

    @GetMapping("/getLocation")
    //ben buraya lng,lat,radius koymam gerek.
    public Response getGeoDetails() {
        UriComponents uri=UriComponentsBuilder.newInstance().scheme("https")
                .host("maps.googleapis.com")
                .path("/maps/api/place/nearbysearch/json")
                .queryParam("key",API_KEY)
                .queryParam("location",location)
                .queryParam("radius",radius)
                .build();
                  System.out.println(uri.toUriString());
        ResponseEntity<Response> response = new RestTemplate().
                getForEntity(uri.toUriString(),
                        Response.class);
        return  response.getBody();
    }

}
