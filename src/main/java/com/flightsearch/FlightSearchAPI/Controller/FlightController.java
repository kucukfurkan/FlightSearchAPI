package com.flightsearch.FlightSearchAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flightsearch.FlightSearchAPI.Model.Flight;
import com.flightsearch.FlightSearchAPI.Service.FlightService;

@RestController
@RequestMapping("/flights")
public class FlightController {
	 	@Autowired
	    private FlightService flightService;
	 	
	 	@GetMapping("/search")
	    public  List<List<Flight>> findSuitableFlights(
	            @RequestParam String departureAirport,
	            @RequestParam String destinationAirport,
	            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String departureDate,
	            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String returnDate
	    ) {
	        if (returnDate == null) {
	            return flightService.findSuitableOneWayFlights(departureAirport, destinationAirport, departureDate);
	        } else {
	            return flightService.findSuitableTwoWayFlights(departureAirport, destinationAirport, departureDate, returnDate);
	        }
	    }
	}

