package com.example.proyectoprogramacionweb.Estates.Estate.Infrastructure.Controllers;

import com.example.proyectoprogramacionweb.Estates.Estate.Domain.Estate;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SearchEstateController {

    @Operation(summary = "Gets the form to be filled in order to search an estate", tags = {"Estate", "Search"})
    @GetMapping(value = "/search/form")
    public ResponseEntity getSearchForm(){
        //TODO: GET to obtain all the page resources that are going to be shown in the search form

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @Operation(summary = "Process the chosen criteria and offers results", tags = {"Estate", "Search"})
    @GetMapping(value = "/search")
    public @ResponseBody ResponseEntity<List<Estate>> getSearchResults(@RequestParam(name = "est_type") String estateType,
                                                                       @RequestParam(name = "min_price") Double minPrice,
                                                                       @RequestParam(name = "max_price") Double maxPrice,
                                                                       @RequestParam(name = "city") String city,
                                                                       @RequestParam(name = "act_type") String actionType,
                                                                       @RequestParam(name = "n_rooms") int nRooms,
                                                                       @RequestParam(name = "n_baths") int nBaths){

        ArrayList<Estate> candidates = new ArrayList<>();
        ArrayList<Estate> allEstates = new ArrayList<>(); //TODO: Load allEstates List with the DB data

        allEstates.forEach(e -> {
            Boolean fulfill = true;

            if(minPrice == null && maxPrice != null){
                if((Double)e.data().get("estatePrice") > maxPrice){
                    fulfill = false;
                }
            }
            else if(minPrice != null && maxPrice == null){
                if((Double)e.data().get("estatePrice") < minPrice){
                    fulfill = false;
                }
            }
            else if(minPrice != null && maxPrice != null){
                if((Double)e.data().get("estatePrice") < minPrice || (Double)e.data().get("estatePrice") > maxPrice){
                    fulfill = false;
                }
            }

            if(estateType != null){
                if(((String)e.data().get("estateType")).compareTo(estateType) != 0){
                    fulfill = false;
                }
            }

            if(actionType != null){
                if(((String)e.data().get("estateAction")).compareTo(actionType) != 0){
                    fulfill = false;
                }
            }

            if(nRooms != 0){
                if((int)e.data().get("estateRoomsNumber") != nRooms){
                    fulfill = false;
                }
            }

            if(nBaths != 0){
                if((int)e.data().get("estateBathroomNumber") != nBaths){
                    fulfill = false;
                }
            }

            if(city != null){
                if(((String)e.data().get("estateCity")).compareTo(city) != 0){
                    fulfill = false;
                }
            }

            if(fulfill)
                candidates.add(e);
        });

        if(candidates.isEmpty()){ //TODO: Show that there´s no items that match the criteria in the frontend
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return new ResponseEntity<>(candidates, HttpStatus.OK);
    }
}
