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
	
	public int lazyTransporting() {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(new Integer(32));
		list.add(new Integer(56));
		list.add(new Integer(76));
		list.add(new Integer(8));
		list.add(new Integer(44));
		list.add(new Integer(60));
		list.add(new Integer(47));
		list.add(new Integer(85));
		list.add(new Integer(71));
		list.add(new Integer(91));
		return movingService.moveElements(1, list);
	}

}
