package com.flightsearch.FlightSearchAPI.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flightsearch.FlightSearchAPI.Model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long>{
    List<Flight> findByDepartureAirportAndDestinationAirportAndDepartureDate(
            String departureAirport, String destinationAirport, String departureDate);


    @Query("SELECT f FROM Flight f " +
           "WHERE (f.departureAirport = :departureAirport AND f.destinationAirport = :destinationAirport AND f.departureDate = :departureDate) " +
           "   OR (f.departureAirport = :destinationAirport AND f.destinationAirport = :departureAirport AND f.returnDate = :returnDate)")
    List<Flight> findSuitableTwoWayFlights(
            @Param("departureAirport") String departureAirport,
            @Param("destinationAirport") String destinationAirport,
            @Param("departureDate") String departureDate,
            @Param("returnDate") String returnDate);
}
