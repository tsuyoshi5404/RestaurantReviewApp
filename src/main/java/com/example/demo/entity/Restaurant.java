package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//DTO


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
	
	
	private int restaurantId;
	private String restaurantName;
	private String catchPhrase;
	private double averageRating;
	
	/*
	 * 平均評価(1.0-5.0)
	 * 0.0はレビューなし
	 * 平均評価表示
	 */
	
	public String formatAverageRating() {
		
		String result;
		
		if(averageRating == 0.0) {
			result = "-";
		} else {
			result = String.format("%.1f", averageRating);
		}
		
		return result;
	}
	
	
	
	
	

}
