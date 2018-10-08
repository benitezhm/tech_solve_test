/**
 * 
 */
package com.techandsolve.test.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techandsolve.test.services.MovingService;

/**
 * @author miguel
 *
 */
@Controller
public class MovingController {
	
	private MovingService movingService;
	
	@Autowired
	public MovingController(MovingService movingService) {
		this.movingService = movingService;
	}
	
	@RequestMapping(value = "/lazyload")
	public void lazyLoading() {
		
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
