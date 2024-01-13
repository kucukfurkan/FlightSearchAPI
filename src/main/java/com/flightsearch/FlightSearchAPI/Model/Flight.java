package com.flightsearch.FlightSearchAPI.Model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Flight {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String departureAirport;
	    private String destinationAirport;
		private String departureDate;
	    private String returnDate;
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
