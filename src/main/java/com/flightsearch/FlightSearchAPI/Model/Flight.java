package com.flightsearch.FlightSearchAPI.Model;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
@Schema(name = "Flight", description = "Flight Model")
public class Flight {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 	@Schema(name = "id", description = "Flight id")
	    private Long id;
	 	
		@Schema(name = "departureAirport", description = "Departure city of the departure flight", example = "SWA")
	    private String departureAirport;
		
		@Schema(name = "destinationAirport", description = "Destination city", example = "OGU")
	    private String destinationAirport;
		
		@Schema(name = "departureDate", description = "Departure date of flight")
		private String departureDate;
		
		@Schema(name = "returnDate", description = "Return date of flight")
	    private String returnDate;
		
		@Schema(name = "price", description = "Price", example = "1299")
	    private double price;
	    
	    public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getDepartureAirport() {
			return departureAirport;
		}
		public void setDepartureAirport(String departureAirport) {
			this.departureAirport = departureAirport;
		}
		public String getDestinationAirport() {
			return destinationAirport;
		}
		public void setDestinationAirport(String destinationAirport) {
			this.destinationAirport = destinationAirport;
		}
		public String getDepartureDate() {
			return departureDate;
		}
		public void setDepartureDate(String departureDate) {
			this.departureDate = departureDate;
		}
		public String getReturnDate() {
			return returnDate;
		}
		public void setReturnDate(String returnDate) {
			this.returnDate = returnDate;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
}
