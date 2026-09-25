package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Review;

public interface ReviewListService {
	
	List<Review> findByRestaurantId(int restaurantId);

}
