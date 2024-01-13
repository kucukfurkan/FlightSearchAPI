package com.flightsearch.FlightSearchAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flightsearch.FlightSearchAPI.Model.Flight;
import com.flightsearch.FlightSearchAPI.Service.FlightService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/flights")
public class FlightController {
	 	@Autowired
	    private FlightService flightService;
	 	
	 	@GetMapping("/search")
	 	@Tag(name = "findSuitableFlights", description = "This endpoint is used for finding suitable flights acoording to 'departureAirport', 'destinationAirport', 'departureDate', 'returnDate'")
	    public  List<List<Flight>> findSuitableFlights(
	            @RequestParam String departureAirport,
	            @RequestParam String destinationAirport,
	            @RequestParam String departureDate,
	            @RequestParam String returnDate
	    ) {
	        if (returnDate == null) {
	            return flightService.findSuitableOneWayFlights(departureAirport, destinationAirport, departureDate);
	        } else {
	            return flightService.findSuitableTwoWayFlights(departureAirport, destinationAirport, departureDate, returnDate);
	        }
	    }
	}

