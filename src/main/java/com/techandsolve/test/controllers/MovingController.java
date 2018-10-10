/**
 * 
 */
package com.techandsolve.test.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techandsolve.test.domain.Case;
import com.techandsolve.test.services.MovingService;

/**
 * @author miguel
 *
 */
@Controller
public class MovingController {
	
//	@SuppressWarnings("serial")
//	static class CaseList extends ArrayList<Case> { }
	
	private MovingService movingService;
	
	@Autowired
	public MovingController(MovingService movingService) {
		this.movingService = movingService;
	}
	
	@PostMapping("/process_input")
	@ResponseBody
	public ArrayList<String> processInputData(@RequestBody List<Case> cases) {
		ArrayList<String> list = new ArrayList<>();
		for (Case caseDay : cases)  {
			String travels = new StringBuilder(caseDay.getCaseName())
					.append(": ")
					.append(String.valueOf(movingService.moveElements(0, caseDay.getElements())))
					.toString();
			list.add(travels);
		}
		return list;
	}
	
	public int lazyTransporting(ArrayList<Integer> list) {
		return movingService.moveElements(1, list);
	}

}
