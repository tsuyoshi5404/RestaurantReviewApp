package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Review;
import com.example.demo.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewListServiceImpl implements ReviewListService {
	
	private final ReviewRepository repository;

	@Override
	public List<Review> findByRestaurantId(int restaurantId) {
		
		List<Review> list = repository.selectByRestaurantId(restaurantId);
		
		return list;
	}

}
