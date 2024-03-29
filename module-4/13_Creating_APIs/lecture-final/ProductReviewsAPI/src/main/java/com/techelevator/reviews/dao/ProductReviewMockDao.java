package com.techelevator.reviews.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.reviews.model.ProductReview;

@Component
public class ProductReviewMockDao implements ProductReviewDao {
	
	private Map<Integer,ProductReview> reviews = new HashMap<>();
	private final String DEFAULT_AVATAR = "https://s3.amazonaws.com/uifaces/faces/twitter/osmanince/128.jpg";
	
	public ProductReviewMockDao() throws JsonParseException, JsonMappingException, IOException {
		loadJSON();
	}

	@Override
	public List<ProductReview> list() {
		return new ArrayList<>(reviews.values());
	}
	
	@Override
	public ProductReview create(ProductReview review) {
		int max = Collections.max(reviews.keySet());
		review.setId(max+1);
		review.setAvatar(this.DEFAULT_AVATAR);
		review.setCreatedAt(new Date());
		reviews.put(review.getId(), review);
		return review;
	}
	
	@Override
	public ProductReview read(int id) {
		return reviews.get(id);
	}
	
	@Override
	public ProductReview update(ProductReview review) {
		ProductReview existingReview = reviews.get(review.getId());
		review.setAvatar(existingReview.getAvatar());
		review.setCreatedAt(existingReview.getCreatedAt());
		reviews.put(review.getId(), review);
		return review;
	}
	
	@Override
	public void delete(int id) {
		reviews.remove(id);
	}

	private void loadJSON() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		InputStream inputStream = this.getClass().getResourceAsStream("/data.json");
		ProductReview[] jsondata = mapper.readValue(inputStream, ProductReview[].class);
		for(ProductReview review : jsondata) {
			reviews.put(review.getId(),review);
		}
	}

	
}
