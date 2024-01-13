package com.flightsearch.FlightSearchAPI.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

public class ScheduledFlightService {
	@Autowired
	private FlightService flightService;

	@Autowired
	private MockDataService mockDataService;

	@Scheduled(cron = "0 0 0 * * ?")
	public void searchFlightsCronJob() {
		// Get mock flight data instead of making a request to a real API.
        String mockFlightData = mockDataService.getMockFlightData();

        // Process the mock flight data and save it to the database.
        flightService.saveFlights(mockFlightData);
	}
}
