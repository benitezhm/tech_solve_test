/**
 * 
 */
package com.techandsolve.test.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.springframework.stereotype.Service;

/**
 * @author miguel
 *
 */
@Service
public class MovingServiceImpl implements MovingService {

	private final int MIN_WEIGHT = 50;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.techandsolve.test.services.MovingService#moveElements(int, int[])
	 */
	@Override
	public int moveElements(int day, ArrayList<Integer> elementsWeight) {
		Collections.sort(elementsWeight, Collections.reverseOrder());
		int travels = 0;
		int totalWeight = 0;
		while (elementsWeight.size() > 0) {
			int index = totalWeight != 0 ? elementsWeight.size()-1 : 0;
			totalWeight +=  elementsWeight.remove(index).intValue();
			
			if (totalWeight - MIN_WEIGHT >= 0) {
				travels += 1;
				totalWeight = 0;
			}
		}
		return travels;
	}

}
