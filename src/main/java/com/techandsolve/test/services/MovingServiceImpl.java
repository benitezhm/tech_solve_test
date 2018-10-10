/**
 * 
 */
package com.techandsolve.test.services;

import java.util.ArrayList;
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
		int maxWeight = 0;
		int packages = 0;
		while (elementsWeight.size() > 0) {
			int index = maxWeight != 0 ? elementsWeight.size()-1 : 0;
			if (maxWeight > 0) {
				elementsWeight.remove(index);
			} else {
				maxWeight =  elementsWeight.remove(index).intValue();
			}
			packages += 1;
			
			if ((maxWeight * packages) >= MIN_WEIGHT) {
				travels += 1;
				maxWeight = 0;
				packages = 0;
			}
		}
		return travels;
	}

}
