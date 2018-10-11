/**
 * 
 */
package com.techandsolve.test.services;

import java.util.ArrayList;
import java.util.List;

import com.techandsolve.test.model.Petition;

/**
 * @author miguel
 *
 */
public interface MovingService {
	
	int moveElements(int day, ArrayList<Integer> elementsWeight);

	void registerPetition(int identification);

	List<Petition> getPetitions();

}
