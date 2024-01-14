package com.flightsearch.FlightSearchAPI.Model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
@Schema(name = "Airport", description = "Airport Model")
public class Airport {
	
	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	  	@Schema(name = "id", description = "Airport id")
	    private Long id;
	  	
	  	@Schema(name = "city", description = "City", example = "Istanbul")
	    private String city;
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
	    
}
