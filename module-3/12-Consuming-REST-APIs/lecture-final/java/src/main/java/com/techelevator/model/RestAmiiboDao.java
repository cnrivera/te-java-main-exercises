package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class RestAmiiboDao implements AmiiboDao {
	
	private static class MultipleAmiiboAPIResponse {
		public List<Amiibo> amiibo = new ArrayList<>();
	}
	
	private static class SingleAmiiboAPIResponse {
		public Amiibo amiibo;
	}
	
	private static final String BASE_URL = "https://www.amiiboapi.com/api/amiibo/";
	
	private RestTemplate restTemplate = new RestTemplate();

	@Override
	public List<Amiibo> getAmiibosForCharacter(String character) {
		
		String url = BASE_URL + "?character=" + character;
		
		MultipleAmiiboAPIResponse response;		
		try {
			response = restTemplate.getForObject(url, MultipleAmiiboAPIResponse.class);
		}
		catch (HttpClientErrorException e) {
			response = new MultipleAmiiboAPIResponse();
		}
		
		return response.amiibo;
	}

	@Override
	public Amiibo getAmiiboById(String id) {
		
		String url = BASE_URL + "?id=" + id;
		
		SingleAmiiboAPIResponse response;		
		try {
			response = restTemplate.getForObject(url, SingleAmiiboAPIResponse.class);
		}
		catch (HttpClientErrorException e) {
			response = new SingleAmiiboAPIResponse();
		}
		
		return response.amiibo;
	}

}
