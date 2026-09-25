package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Review;
import com.example.demo.form.ReviewEditForm;
import com.example.demo.service.EditService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class EditController {
	
	private final EditService service;
	
	//レビュー登録画面表示リクエスト
	@PostMapping("/show-edit-form")
	public String showEditForm(@ModelAttribute ReviewEditForm form) {
		return "edit-review";
	}
	
	
	
	//レビュー更新画面リクエスト（編集画面より）
	@PostMapping("/edit-review")
	public String registReview(@Validated @ModelAttribute ReviewEditForm form, BindingResult result)
	{
		//入力エラーがある場合にはレビュー登録画面に戻す
		if(result.hasErrors()) {
			return "edit-review";
		}
		
		//正常な場合にレビュー登録画面に遷移する
		return "confirm-edit-review";
	}
	
	
	//レビュー更新リクエスト（登録確認画面より）
	@PostMapping("/confirm-edit-review")
	public String confirmEditReview(@Validated ReviewEditForm form, BindingResult result,
			RedirectAttributes redirectAttributes) {
		
		//入力エラーがあるときはレビュー登録画面に戻す
		if (result.hasErrors()) {
			return "edit-review";
		}
		
		Review r = new Review();
		r.setReviewId(form.getReviewId());
		r.setRestaurantId(form.getRestaurantId());
		r.setUserId(form.getUserId());
		r.setVisitDate(form.getVisitDate());
		r.setRating(form.getRating());
		r.setComment(form.getComment());
		
		//実際のサービス層の業務処理を呼び出す
		service.edit(r);
		
		
		redirectAttributes.addFlashAttribute("msg", "(レビュー登録)");
		
		
		return "redirect:/complete";
	}

}
