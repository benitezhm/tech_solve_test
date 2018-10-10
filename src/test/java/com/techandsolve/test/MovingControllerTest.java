/**
 * 
 */
package com.techandsolve.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.techandsolve.test.controllers.MovingController;
import com.techandsolve.test.services.MovingServiceImpl;

/**
 * @author miguel
 *
 */
public class MovingControllerTest {
	
	/**
	 * Controller for lazy moving 
	 */
	private MovingController movingController;
	
	@Before
	public void setUp() throws Exception {
		this.movingController = new MovingController(new MovingServiceImpl());
		
		
		
	}
	
	@Test
	public void testLazyTravelsCase1() throws Exception {
		// Case 1
		ArrayList<Integer> list = new ArrayList<>();
		list.add(new Integer(30));
		list.add(new Integer(30));
		list.add(new Integer(1));
		list.add(new Integer(1));
		assertEquals(2, movingController.lazyTransporting(list));
		
	}
	
	@Test
	public void testLazyTravelsCase2() throws Exception {
		// Case 2
		ArrayList<Integer> list = new ArrayList<>();
		list.add(new Integer(20));
		list.add(new Integer(20));
		list.add(new Integer(20));
		assertEquals(1, movingController.lazyTransporting(list));
	}
	
	@Test
	public void testLazyTravelsCase3() throws Exception {
		// Case 3
		ArrayList<Integer> list = new ArrayList<>();
		list.add(new Integer(1));
		list.add(new Integer(2));
		list.add(new Integer(3));
		list.add(new Integer(4));
		list.add(new Integer(5));
		list.add(new Integer(6));
		list.add(new Integer(7));
		list.add(new Integer(8));
		list.add(new Integer(9));
		list.add(new Integer(10));
		list.add(new Integer(11));
		assertEquals(2, movingController.lazyTransporting(list));
	}
	
	@Test
	public void testLazyTravelsCase4() throws Exception {
		// Case 3
		ArrayList<Integer> list = new ArrayList<>();
		list.add(new Integer(9));
		list.add(new Integer(19));
		list.add(new Integer(29));
		list.add(new Integer(39));
		list.add(new Integer(49));
		list.add(new Integer(59));
		assertEquals(3, movingController.lazyTransporting(list));
	}
	
	@Test
	public void testLazyTravelsCase5() throws Exception {
		// Case 3
		ArrayList<Integer> list = new ArrayList<>();
		list.add(new Integer(9));
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
		assertEquals(8, movingController.lazyTransporting(list));
	}

}
