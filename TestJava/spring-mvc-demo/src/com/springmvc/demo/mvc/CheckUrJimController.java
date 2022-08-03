package com.springmvc.demo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class CheckUrJimController {
	 @RequestMapping("/jimform")
	 public String JimForm() {
		 return "jimform";
	 }
	 
	 @RequestMapping("/jimprocess")
	 public String JimProcess() {
		 return "jimprocess";
	 }
	 
//	 @RequestMapping("/jimprocessV2")
//	 public String JimShoutOut(HttpServletRequest request, Model model) {
//		 String hittinPost = request.getParameter("jimask");
//		 
//		 hittinPost = hittinPost.toUpperCase();
//		 
//		 model.addAttribute("hittinPost", "thismfhittin " + hittinPost);
//		 
//		 return "jimprocess";
//	 }
	 
	 @RequestMapping("/jimprocessV2")
	 public String JimShoutOut(@RequestParam("jimask") String hittinPost, Model model) {
		 hittinPost = hittinPost.toUpperCase();
		 
		 model.addAttribute("hittinPost", "thismfhittin " + hittinPost);
		 
		 return "jimprocess";
	 }
	 
}
