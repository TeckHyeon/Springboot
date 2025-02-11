package com.parametertest.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.parametertest.domain.DataVo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/temp", method = RequestMethod.GET)
	public String temp(String a, int b) {
		System.out.println("a=" + a);
		System.out.println("b=" + (b + 3));
		System.out.println("/temp 호출");
		return "none";

	}

	@RequestMapping("/temp1")
	public String tmpe1(HttpServletRequest request, HttpServletResponse response) {
		String in_a = request.getParameter("a");
		String in_b = request.getParameter("b");

		String a = in_a;
		int b = Integer.parseInt(in_b) + 3;
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		return "none";

	}

	@RequestMapping("/temp2")
	public String tmpe2(@RequestParam Map<String, String> map) {
		System.out.println("map:" + map);
		String a = map.get("a");
		int b = Integer.parseInt(map.get("b"));
		System.out.println("a = " + a);
		System.out.println("b = " + (b + 5));
		return "none";
	}

	@RequestMapping("/temp3")
	public String tmpe3(@RequestParam("a") String v1, @RequestParam("b") int v2) {

		System.out.println("a = " + v1);
		System.out.println("b = " + (v2 + 5));
		return "none";
	}

	@RequestMapping("/temp4")
	public String tmpe4(DataVo vo) {
		System.out.println("a = " + vo.getA());
		System.out.println("b = " + (vo.getB() + 5));
		return "none";
	}

	@RequestMapping("/temp5")
	public String tmpe5(String a, int b, Model model) {

		System.out.println("a = " + a);
		System.out.println("b = " + (b + 5));
		System.out.println("c = " + "이것도 되나?");

		model.addAttribute("a", a);
		model.addAttribute("b", b);
		model.addAttribute("c", "이것도 되나?");

		return "reqdata";

	}

	@RequestMapping("/temp6")
	public String tmpe6(String a, int b, Model model, DataVo vo) {

		System.out.println("a = " + vo.getA());
		System.out.println("b = " + (vo.getB() + 5));

		System.out.println("a = " + a);
		System.out.println("b = " + (b + 5));
		System.out.println("c = " + "이것도 되나?");

		model.addAttribute("a", vo.getA());
		model.addAttribute("b", (vo.getB() + 5));
		model.addAttribute("c", "이것도 되나?");

		return "reqdata";

	}

	@RequestMapping("/temp7")
	public String tmpe7(@ModelAttribute("attrName") DataVo vo, Model model) {

		System.out.println("a = " + vo.getA());
		System.out.println("b = " + (vo.getB() + 5));

		model.addAttribute("a", vo.getA());
		model.addAttribute("b", vo.getB());

		return "noneModel";

	}

	@RequestMapping("/temp8/{a}/{b}")
	public String tmpe8(@PathVariable("a") String a, @PathVariable("b") int b) {
		System.out.println("a = " + a);
		System.out.println("b = " + (b + 5));

		return "none";

	}
	@RequestMapping("/temp9/{a}/{b}")
	public String tmpe9(DataVo vo) {
		System.out.println("a = " + vo.getA());
		System.out.println("b = " + (vo.getB() + 5));
		
		return "none";
		
	}
	@RequestMapping("/temp10/{a}/{b}")
	public String tmpe10(@ModelAttribute("vo") DataVo vo, Model model) {
		System.out.println("a = " + vo.getA());
		System.out.println("b = " + (vo.getB() + 5));

		model.addAttribute("a", vo.getA());
		model.addAttribute("b", vo.getB());
		
		return "noneModel";
		
	}

}
