package com.flightsearch.FlightSearchAPI.Service;

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
}
