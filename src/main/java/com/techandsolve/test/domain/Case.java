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
	
	private ArrayList<Integer> elements;
	
	private int identification;
	
	public Case() {
		
	}
	
	public Case(String caseName, ArrayList<Integer> elements, int identification) {
		super();
		this.caseName = caseName;
		this.elements = elements;
		this.identification = identification;
	}

	public int getIdentification() {
		return identification;
	}

	public void setIdentification(int identification) {
		this.identification = identification;
	}

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
