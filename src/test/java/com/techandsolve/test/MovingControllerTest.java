/**
 * 
 */
package com.techandsolve.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.techandsolve.test.controllers.MovingController;
import com.techandsolve.test.services.MovingServiceImpl;

/**
 * @author miguel
 *
 */
public class MovingControllerTest {
	
	private MovingController movingController;
	
	@Before
	public void setUp() throws Exception {
		this.movingController = new MovingController(new MovingServiceImpl());
	}
	
	@Test
	public void testLazyTravels() throws Exception {
		assertEquals(8, movingController.lazyTransporting());
	}

}
