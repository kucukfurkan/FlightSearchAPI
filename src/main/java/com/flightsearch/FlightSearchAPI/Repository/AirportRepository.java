package com.flightsearch.FlightSearchAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightsearch.FlightSearchAPI.Model.Airport;

public interface AirportRepository extends JpaRepository<Airport, Long> {
	
}
