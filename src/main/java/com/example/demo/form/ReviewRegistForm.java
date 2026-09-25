package com.example.demo.form;

import java.sql.Date;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class ReviewRegistForm {
	
	@NotNull(message = "入力してください")
	@Min(value = 1, message = "正の整数を入力してください")
	private Integer restaurantId;
	
	private String restaurantName;
	
	@Size(min = 4,max = 16, message  = "今日以前の日付を入力してください")
	private String userId;
	
	@NotNull(message = "来店日を入力してください")
	@PastOrPresent(message = "日付を正しく入力してください")
	private Date visitDate;
	
	@NotNull(message = "入力してください")
	@Min(value = 1,message = "1-5で指定してください")
	@Max(value = 5,message = "1-5で指定してください")
	private Integer rating;
	
	@Size(min = 1, max = 128, message = "1-128文字で指定してください")
	private String comment;

}
