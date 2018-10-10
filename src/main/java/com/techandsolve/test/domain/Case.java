/**
 * 
 */
package com.techandsolve.test.domain;

import java.util.ArrayList;

/**
 * @author miguel
 *
 */
public class Case {
	
	private String caseName;
	
	public Case() {
		
	}
	
	private ArrayList<Integer> elements;

	public String getCaseName() {
		return caseName;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	public ArrayList<Integer> getElements() {
		return elements;
	}

	public void setElements(ArrayList<Integer> cases) {
		this.elements = cases;
	}

}
