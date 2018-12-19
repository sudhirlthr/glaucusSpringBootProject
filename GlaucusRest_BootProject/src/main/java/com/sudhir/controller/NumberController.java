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
 * @author : Sudhir Kumar
 * 
 * front controller to accept request from localhost:8080/glaucus
 * and then forward model in thymleaf for showing the latest number
 *
 */
@Controller
@RequestMapping("/glaucus")// requested URL
public class NumberController {

	// Inject dependency to update the number for each request
	@Autowired
	private Number_Repository number_Repository;
	
	// To get type of Request and forward the response accordingly
	// and make this method as synchronized to serve each request as it comes and keep in pipeline for their execution
	@RequestMapping(method=RequestMethod.GET)
	public synchronized String home(Map<String, Integer> model) {
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
