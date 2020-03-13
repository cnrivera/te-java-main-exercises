package com.techelevator.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonAnySetter;

public class RestWeatherDao {
	
	private static class DarkSkyDataPoint {
		public String summary;
		public String icon;
		public String precipType;
		
		public Double temperatureLow;
						
		@JsonAnySetter
		public Map<String, Double> details = new HashMap<>();
	}

	private static class DarkSkyDataBlock {
		public List<DarkSkyDataPoint> data;
	}

	private static class DarkSkyForecast {
		public DarkSkyDataBlock daily;
	}
	
	private static final String BASE_URL = "https://api.darksky.net/forecast/2fe39f20e170590d1147117710367b6e/";

	private RestTemplate restTemplate = new RestTemplate();
	
	public List<WeatherForecast> getDailyWeather() {
		String coordinates = "37.8267,-122.4233";
		DarkSkyForecast forecast = restTemplate.getForObject(BASE_URL + coordinates, DarkSkyForecast.class);
		
		List<WeatherForecast> results = new ArrayList<>();
		for (DarkSkyDataPoint dp : forecast.daily.data) {
			WeatherForecast w = new WeatherForecast();
			w.setHighTemp(dp.details.get("temperatureHigh"));
			w.setLowTemp(dp.temperatureLow);
			results.add(w);		
		}
		
		return results;
	}

}
