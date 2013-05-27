package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asgn2Exceptions.TrainException;
import asgn2RollingStock.RollingStock;
import asgn2RollingStock.Locomotive;

public class RollingStockTest {

	RollingStock rollingStockTest;
	
	@Test(expected = TrainException.class)
	public void testNegativeGrossWeight() throws TrainException {
		rollingStockTest = new Locomotive(-10, "2E");
	}
	
	@Test(expected = TrainException.class)
	public void testZeroGrossWeight() throws TrainException {
		rollingStockTest = new Locomotive(0, "2E");
	}
	
	@Test
	public void testGetGrossWeight() throws TrainException {
		rollingStockTest = new Locomotive(90, "2E");
		assertEquals((Integer) 90, rollingStockTest.getGrossWeight());
	}
	
	@Test
	public void testToString() throws TrainException {
		rollingStockTest = new Locomotive(90, "2E");
		assertEquals("Loco (" + "2E" + ")", rollingStockTest.toString());
	}
}
