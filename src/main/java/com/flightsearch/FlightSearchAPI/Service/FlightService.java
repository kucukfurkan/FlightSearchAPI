package com.flightsearch.FlightSearchAPI.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightsearch.FlightSearchAPI.Model.Flight;
import com.flightsearch.FlightSearchAPI.Repository.FlightRepository;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;
    
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }

    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight updateFlight(Long id, Flight flight) {
        flight.setId(id);
        return flightRepository.save(flight);
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }
    
    public  List<List<Flight>> findSuitableOneWayFlights(String departureAirport, String destinationAirport, String departureDate) {
    	 flightRepository.findByDepartureAirportAndDestinationAirportAndDepartureDate(departureAirport, destinationAirport, departureDate);
    	 List<Flight> returnFlights = new ArrayList<>();
    	 
    	 	//Create a null list because  it is a one-way flight.
    	 	List<Flight> emptyFlights = new ArrayList<>();
     	 	List<List<Flight>> result = new ArrayList<>();
     	 	
           result.add(returnFlights);
           result.add(emptyFlights);
           return result;
    }

    public  List<List<Flight>> findSuitableTwoWayFlights(String departureAirport, String destinationAirport, String departureDate, String returnDate) {
        List<Flight> departureFlights = flightRepository.findByDepartureAirportAndDestinationAirportAndDepartureDate(departureAirport, destinationAirport, departureDate);
        
        //For return flight, this time destinationAirport is departureAirport and departureAirport is destinationAirport. 
        List<Flight> returnFlights = flightRepository.findByDepartureAirportAndDestinationAirportAndDepartureDate(destinationAirport, departureAirport, returnDate);
        
        // Check for null and return empty lists if needed
        if (departureFlights == null) {
            departureFlights = new ArrayList<>();
        }
        if (returnFlights == null) {
        	returnFlights = new ArrayList<>();
        }

        List<List<Flight>> result = new ArrayList<>();
        result.add(departureFlights);
        result.add(returnFlights);
        return result;
    }
}
