package com.flightsearch.FlightSearchAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public List<List<Flight>> findSuitableFlights(@RequestParam String departureAirport,
			@RequestParam String destinationAirport, @RequestParam String departureDate,
			@RequestParam String returnDate) {
		if (returnDate == null) {
			return flightService.findSuitableOneWayFlights(departureAirport, destinationAirport, departureDate);
		} else {
			return flightService.findSuitableTwoWayFlights(departureAirport, destinationAirport, departureDate,
					returnDate);
		}
	}

	@PostMapping("/createFlight")
	//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@Tag(name = "createFlight", description = "This endpoint is used for creating new flights")
	public void createFlight(@RequestParam String departureAirport, @RequestParam String destinationAirport,
			@RequestParam String departureDate, @RequestParam String returnDate, @RequestParam Double price) {
		Flight flight = new Flight();
		flight.setDepartureAirport(departureAirport);
		flight.setDepartureDate(departureDate);
		flight.setDestinationAirport(destinationAirport);
		flight.setReturnDate(returnDate);
		flight.setPrice(price);

		flightService.createFlight(flight);
	}

	@GetMapping("/getAllFlights")
	//@PreAuthorize("hasAuthority('ROLE_USER')")
	@Tag(name = "GetAllFlights", description = "This endpoint is used for fetching all flights from db")
	public List<Flight> GetAllFlights() {
		return flightService.getAllFlights();
	}

}
