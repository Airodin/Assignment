package asgn2Tests;

import asgn2RollingStock.FreightCar;
import asgn2Exceptions.TrainException;

import org.junit.Test;
import static org.junit.Assert.*;

public class FreightCarTest {
	
	private static final Integer NEGATIVE_GROSS_WEIGHT = -1;
	private static final Integer VALID_GROSS_WEIGHT = 50;
	private static final String VALID_GOOD_TYPE = "G";
	private static final String INVALID_GOOD_TYPE = "C";
	private static final String LOWER_CASE_OF_GOOD_TYPE = "g";
	private static final Integer ZERO_GROSS_WEIGHT = 0;

	FreightCar testFreightCar;
	
	//NEGATIVE_GROSS_WEIGHT
	@Test(expected = TrainException.class)
	public void testFreightCarWithNegativeWeight() throws TrainException{
		testFreightCar = new FreightCar(NEGATIVE_GROSS_WEIGHT, VALID_GOOD_TYPE);
	}

	//ZERO_GROSS_WEIGHT
	@Test(expected = TrainException.class)
	public void testFreightCarWithZeroWeight() throws TrainException {
		testFreightCar = new FreightCar(ZERO_GROSS_WEIGHT, VALID_GOOD_TYPE);
	}
	
	//INVALID_GOOD_TYPE
	@Test(expected = TrainException.class)
	public void testFreightCarWithInvalidGoodType() throws TrainException {
		testFreightCar = new FreightCar(VALID_GROSS_WEIGHT, INVALID_GOOD_TYPE);
	}
	
	/*--------------------------------------------------------------------------------*/
	/*--------------------------------------------------------------------------------*/
	/*--------------------------------------------------------------------------------*/
	
	//VALID_GROSS_WEIGHT, VALID_GOOD_TYPE "D"
	@Test 
	public void testFreightCarWithGoodTypeD() throws TrainException{
		testFreightCar = new FreightCar(VALID_GROSS_WEIGHT, "D" );
		assertEquals("D", testFreightCar.goodsType());
 	}
	
	//VALID_GROSS_WEIGHT, VALID_GOOD_TYPE "G"
	@Test 
	public void testFreightCarWithGoodTypeG() throws TrainException{
		testFreightCar = new FreightCar(VALID_GROSS_WEIGHT , "G");
		assertEquals("G", testFreightCar.goodsType());
 	}
	
	//VALID_GROSS_WEIGHT, VALID_GOOD_TYPE "R"
	@Test 
	public void testFreightCarWithGoodTypeR() throws TrainException{
		testFreightCar = new FreightCar(VALID_GROSS_WEIGHT , "R");
		assertEquals("R", testFreightCar.goodsType());
 	}
	
	//VALID_GROSS_WEIGHT, VALID_GOOD_TYPE "R"
	@Test 
	public void testFreightCarWithLowerCaseOfGoodType() throws TrainException{
		testFreightCar = new FreightCar(VALID_GROSS_WEIGHT , LOWER_CASE_OF_GOOD_TYPE);
		assertEquals(LOWER_CASE_OF_GOOD_TYPE.toUpperCase(), testFreightCar.goodsType());
 	}
	
	//test GoodsType() with VALID_GROSS_WEIGHT, VALID_GOOD_TYPE
	@Test 
	public void testGoodsType() throws TrainException{
		testFreightCar = new FreightCar(VALID_GROSS_WEIGHT , VALID_GOOD_TYPE);
		assertEquals(testFreightCar.goodsType(), VALID_GOOD_TYPE);
 	}
	
	//test toString() with VALID_GROSS_WEIGHT, VALID_GOOD_TYPE
	@Test 
	public void testToString() throws TrainException{
		testFreightCar = new FreightCar(VALID_GROSS_WEIGHT , VALID_GOOD_TYPE);
		assertEquals("Freight (" + VALID_GOOD_TYPE +")" ,testFreightCar.toString());
 	}		
}
