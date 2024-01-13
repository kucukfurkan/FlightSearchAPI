package com.flightsearch.FlightSearchAPI.Service;

import org.springframework.stereotype.Service;

@Service
public class MockDataService {

    public String getMockFlightData() {

        return "[{\"departureAirport\":\"SWA\",\"destinationAirport\":\"OGU\",\"departureDate\":\"2024-01-30\",\"returnDate\":\"2024-01-31\",\"price\":\"1299\"}]";
    }
}
