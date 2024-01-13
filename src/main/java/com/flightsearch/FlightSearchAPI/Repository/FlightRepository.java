package com.flightsearch.FlightSearchAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightsearch.FlightSearchAPI.Model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long>{
	
}
