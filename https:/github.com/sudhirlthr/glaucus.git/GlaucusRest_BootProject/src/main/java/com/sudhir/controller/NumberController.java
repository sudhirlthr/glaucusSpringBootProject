/**
 * 
 */
package com.sudhir.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sudhir.repository.Number_Repository;

/**
 * @author sudhir
 *
 */
@Controller
@RequestMapping("/")
public class NumberController {

	private Number_Repository number_Repository;
	
	@Autowired
	public NumberController(Number_Repository number_Repository) {
		this.number_Repository = number_Repository;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Map<String, Integer> model) {
		number_Repository.saveNumber();
		Integer number = number_Repository.getNumber();
		model.put("number", number);
		return "home";
	}
	
	/*@RequestMapping(method=RequestMethod.POST)
	public String submitNumber() {
		number_Repository.saveNumber();
		return "redirect:/";
	}*/
}
