package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Review;
import com.example.demo.form.ReviewRegistForm;
import com.example.demo.service.RegistService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class RegistController {
	private final RegistService service;
	//レビュー登録画面表示リクエスト
	@PostMapping("/show-review-form")
	public String showReviewForm(@ModelAttribute ReviewRegistForm form) {
		return "regist-review";
	}
	
	//レビュー登録画面表示リクエスト（確認画面からの戻り）
	@PostMapping("/show-review-form-ret")
	public String showReviewFormRet(@ModelAttribute ReviewRegistForm form) {
		return "regist-review";
	}
	
	//レビュー登録画面リクエスト（登録画面より）
	@PostMapping("/regist-review")
	public String registReview(@Validated @ModelAttribute ReviewRegistForm form, BindingResult result) {
		//入力エラーがある場合にはレビュー登録画面に戻す
		if(result.hasErrors()) {
			return "regist-review";
		}
		
		//正常な場合にレビュー登録画面に遷移する
		return "confirm-regist-review";
	}
	
	//レビュー登録リクエスト（登録確認画面より）
	@PostMapping("/confirm-regist-review")
	public String confirmRegistReview(@Validated ReviewRegistForm form, BindingResult result,
			RedirectAttributes redirectAttributes) {
		//入力エラーがあるときはレビュー登録画面に戻す
		if (result.hasErrors()) {
			return "regist-review";
		}
		
		Review r = new Review();
		r.setRestaurantId(form.getRestaurantId());
		r.setUserId(form.getUserId());
		r.setVisitDate(form.getVisitDate());
		r.setRating(form.getRating());
		r.setComment(form.getComment());
		service.regist(r);
		
		redirectAttributes.addFlashAttribute("msg", "(レビュー登録)");
		
		
		return "redirect:/complete";
	}

}
