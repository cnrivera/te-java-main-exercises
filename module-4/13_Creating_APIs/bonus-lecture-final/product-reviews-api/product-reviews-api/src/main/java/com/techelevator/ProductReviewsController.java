package com.techelevator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.techelevator.reviews.dao.ProductReviewDao;
import com.techelevator.reviews.model.ProductReview;

@RestController
@RequestMapping("/api")
public class ProductReviewsController {
	
	private ProductReviewDao productReviewDao;
	
	@Autowired
	public ProductReviewsController(ProductReviewDao productReviewDao) {
		this.productReviewDao = productReviewDao;
	}

	@GetMapping("/reviews")
	public List<ProductReview> getAllReviews() {
		return productReviewDao.list();
	}

	@GetMapping("/reviewers")
	public List<String> getAllReviewers() {
		return productReviewDao.listReviewers();
	}
	
	@PostMapping(path = "/reviews", consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public ProductReview postReview(@RequestBody ProductReview newReview) {
		return productReviewDao.create(newReview);
	}
	
	@GetMapping("/reviews/{id}")
	public ProductReview getReview(@PathVariable int id) {
		ProductReview result = productReviewDao.read(id);
		if (result == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return result;
	}
	
	@PutMapping("/reviews/{id}")
	public ProductReview putReview(@PathVariable int id, @RequestBody ProductReview updatedReview) {	
		ProductReview result = null;
		if (reviewExists(id)) {
			updatedReview.setId(id);
			result = productReviewDao.update(updatedReview);
		}
		return result;
	}
	
	@DeleteMapping("/reviews/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteReview(@PathVariable int id) {
		if (reviewExists(id)) {
			productReviewDao.delete(id);
		}
	}
	
	private boolean reviewExists(int id) {
		ProductReview existingReview = productReviewDao.read(id);
		if (existingReview == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return true;
	}

}
