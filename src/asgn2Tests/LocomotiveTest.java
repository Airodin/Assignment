package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asgn2Exceptions.TrainException;
import asgn2RollingStock.Locomotive;;

public class LocomotiveTest {
	private static final String VALID_CLASSIFICATION = "2E";
	private static final String INVALID_ENGINE_TYPE = "2Q";
	private static final String LOWER_CASE_ENGINE_TYPE = "2s";
	private static final String INVALID_POWER_CLASS = "WE";
	private static final String INVALID_CLASSIFICATION_FORMAT = "11E";
	private static final Integer NEGATIVE_GROSS_WEIGHT = -10;
	private static final Integer VALID_GROSS_WEIGHT = 90;
	private static final Integer ZERO_GROSS_WEIGHT = 0;
	
	Locomotive locomotiveTest;
	
	@Test(expected = TrainException.class)
	public void testLocomotiveWithNegativeWeight() throws TrainException {
		locomotiveTest = new Locomotive(NEGATIVE_GROSS_WEIGHT, VALID_CLASSIFICATION);
	}
	
	@Test(expected = TrainException.class)
	public void testLocomotiveWithZeroWeight() throws TrainException {
		locomotiveTest = new Locomotive(ZERO_GROSS_WEIGHT, VALID_CLASSIFICATION);
	}
	
	@Test(expected = TrainException.class)
	public void testLocomotiveWithInvalidClassificationFormat() throws TrainException {
		locomotiveTest = new Locomotive(VALID_GROSS_WEIGHT, INVALID_CLASSIFICATION_FORMAT);
	}
	
	@Test(expected = TrainException.class)
	public void testLocomotiveWithInvalidPowerClass() throws TrainException {
		locomotiveTest = new Locomotive(VALID_GROSS_WEIGHT, INVALID_POWER_CLASS);
	}
	
	@Test(expected = TrainException.class)
	public void testLocomotiveWithInvalidPowerClass1() throws TrainException {
		locomotiveTest = new Locomotive(VALID_GROSS_WEIGHT, "0E");
	}
	
	
	// a locomotive classified as only "1E" which weighs 110 tonnes cannot move!
	@Test
	public void testLocomotiveWhenGrossWeightEqualsPullingPower() throws TrainException {
		locomotiveTest = new Locomotive(100, "1E");
	}
	
	@Test(expected = TrainException.class)
	public void testLocomotiveWhenGrossWeightBiggerPullingPower() throws TrainException {
		locomotiveTest = new Locomotive(110, "1E");
	}
	
	@Test
	public void testLocomotiveWhenGrossWeightSmallerPullingPower() throws TrainException {
		locomotiveTest = new Locomotive(90, "1E");
	}
	
	@Test(expected = TrainException.class)
	public void testLocomotiveWithInvalidEngineType() throws TrainException {
		locomotiveTest = new Locomotive(VALID_GROSS_WEIGHT, INVALID_ENGINE_TYPE);
	}
	
	@Test
	public void testLocomotiveWithInvalidEngineTypeE() throws TrainException {
		locomotiveTest = new Locomotive(VALID_GROSS_WEIGHT, "2E");
	}
	
	@Test
	public void testLocomotiveWithInvalidEngineTypeD() throws TrainException {
		locomotiveTest = new Locomotive(VALID_GROSS_WEIGHT, "2D");
	}
	
	@Test
	public void testLocomotiveWithInvalidEngineTypeS() throws TrainException {
		locomotiveTest = new Locomotive(VALID_GROSS_WEIGHT, "2S");
	}
	
	@Test
	public void testLocomotiveWithLowerCaseEngineType() throws TrainException {
		locomotiveTest = new Locomotive(VALID_GROSS_WEIGHT, LOWER_CASE_ENGINE_TYPE);
	}

	@Test 
	public void testPower() throws TrainException{
		locomotiveTest = new Locomotive(VALID_GROSS_WEIGHT, VALID_CLASSIFICATION);
		assertEquals((Integer)(2*100) , locomotiveTest.power());
	}
	
	//test toString() with VALID_GROSS_WEIGHT, VALID_GOOD_TYPE
	@Test 
	public void testToString() throws TrainException{
		locomotiveTest = new Locomotive(VALID_GROSS_WEIGHT, VALID_CLASSIFICATION);
		assertEquals("Loco (" + VALID_CLASSIFICATION +")" , locomotiveTest.toString());
	}
}
