package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Review;
import com.example.demo.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RemoveServiceImpl implements RemoveService {
	
	private final ReviewRepository repository;

	@Override
	public void remove(Review review) {
		repository.delete(review);

	}

}
