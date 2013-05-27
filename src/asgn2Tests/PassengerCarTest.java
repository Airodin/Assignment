package asgn2Tests;

import asgn2RollingStock.PassengerCar;
import asgn2Exceptions.TrainException;
import static org.junit.Assert.*;

import org.junit.Test;

public class PassengerCarTest {
	
	private static final Integer NEGATIVE_GROSS_WEIGHT = -1;
	private static final Integer ZERO_GROSS_WEIGHT = 0;
	private static final Integer VALID_GROSS_WEIGHT = 90;
	
	private static final Integer NEGATIVE_NEW_PASSENGERS = -3;
	private static final Integer ZERO_NEW_PASSENGERS = 0;
	private static final Integer VALID_NEW_PASSENGERS = 10;
	
	private static final Integer NEGATIVE_DEPARTING_PASSENGERS = -3;
	private static final Integer ZERO_DEPARTING_PASSENGERS = 0;
	private static final Integer VALID_DEPARTING_PASSENGERS = 5;
	
	private static final Integer VALID_NUMBER_OF_SEATS = 50;
	private static final Integer INVALID_NUMBER_OF_SEATS = -1;
	
	PassengerCar passengerCarTest;
	
	//NEGATIVE_GROSS_WEIGHT
	@Test(expected = TrainException.class)
	public void testPassengerCarWithNegativeWeight() throws TrainException{
		passengerCarTest = new PassengerCar(NEGATIVE_GROSS_WEIGHT, VALID_NUMBER_OF_SEATS);
	}		

	//ZERO_GROSS_WEIGHT
	@Test(expected = TrainException.class)
	public void testPassengerCarWithZeroWeight() throws TrainException {
		passengerCarTest = new PassengerCar(ZERO_GROSS_WEIGHT, VALID_NUMBER_OF_SEATS);
	}
	
	//INVALID_NUMBER_OF_SEATS
	@Test(expected = TrainException.class)
	public void testPassengerCarWithNegativeSeats() throws TrainException {
		passengerCarTest = new PassengerCar(VALID_GROSS_WEIGHT, INVALID_NUMBER_OF_SEATS);
	}
	
	//NEGATIVE_NEW_PASSENGERS
	@Test(expected = TrainException.class)
	public void testBoardWithNegativeNewPassengers() throws TrainException {
		passengerCarTest = new PassengerCar(VALID_GROSS_WEIGHT, VALID_NUMBER_OF_SEATS);
		passengerCarTest.board(NEGATIVE_NEW_PASSENGERS);
	}

	@Test(expected = TrainException.class)
	public void testAlightWithTheNumDepartingPassengersExceedsTheNumPassengersOnBoard() throws TrainException {
		passengerCarTest = new PassengerCar(VALID_GROSS_WEIGHT, VALID_NUMBER_OF_SEATS);
		passengerCarTest.board(VALID_NEW_PASSENGERS);
		passengerCarTest.alight(VALID_DEPARTING_PASSENGERS * 3);
	}

	@Test(expected = TrainException.class)
	public void testAlightWithNegativeDepartingPassengers() throws TrainException {
		passengerCarTest = new PassengerCar(VALID_GROSS_WEIGHT, VALID_NUMBER_OF_SEATS);
		passengerCarTest.board(VALID_NEW_PASSENGERS);
		passengerCarTest.alight(NEGATIVE_DEPARTING_PASSENGERS);
	}
	
	/*--------------------------------------------------------------------------------*/
	/*--------------------------------------------------------------------------------*/
	/*--------------------------------------------------------------------------------*/
	
	@Test
	public void testBoardWithNewPassengersGetOnMoreThanEmptySeats() throws TrainException {
		passengerCarTest = new PassengerCar(VALID_GROSS_WEIGHT, VALID_NUMBER_OF_SEATS);
		assertTrue(passengerCarTest.board(60).equals(10));
	}
	
	@Test
	public void testBoardWithNewPassengersGetOnEqualEmptySeats() throws TrainException {
		passengerCarTest = new PassengerCar(VALID_GROSS_WEIGHT, VALID_NUMBER_OF_SEATS);
		assertTrue(passengerCarTest.board(VALID_NUMBER_OF_SEATS).equals(0));
	}
	
	@Test
	public void testBoardWithNewPassengersGetOnLessThanEmptySeats() throws TrainException {
		passengerCarTest = new PassengerCar(VALID_GROSS_WEIGHT, VALID_NUMBER_OF_SEATS);
		assertTrue(passengerCarTest.board(VALID_NUMBER_OF_SEATS).equals(0));
	}
	
	@Test
	public void testBoardWithZeroNewPassengers() throws TrainException {
		passengerCarTest = new PassengerCar(VALID_GROSS_WEIGHT, VALID_NUMBER_OF_SEATS);
		passengerCarTest.board(ZERO_NEW_PASSENGERS);
		assertEquals(ZERO_NEW_PASSENGERS, passengerCarTest.numberOnBoard());
	}
	
	@Test
	public void testBoardWithValidNewPassengers() throws TrainException {
		passengerCarTest = new PassengerCar(VALID_GROSS_WEIGHT, VALID_NUMBER_OF_SEATS);
		passengerCarTest.board(VALID_NEW_PASSENGERS);
		assertEquals(VALID_NEW_PASSENGERS, passengerCarTest.numberOnBoard());
	}
	
	@Test
	public void testAlightWithZeroDepartingPassengers() throws TrainException {
		passengerCarTest = new PassengerCar(VALID_GROSS_WEIGHT, VALID_NUMBER_OF_SEATS);
		passengerCarTest.board(VALID_NEW_PASSENGERS);
		passengerCarTest.alight(ZERO_DEPARTING_PASSENGERS);
		assertEquals(VALID_NEW_PASSENGERS, passengerCarTest.numberOnBoard());
	}
	
	@Test
	public void testAlightWithValidDepartingPassengers() throws TrainException {
		passengerCarTest = new PassengerCar(VALID_GROSS_WEIGHT, VALID_NUMBER_OF_SEATS);
		passengerCarTest.board(VALID_NEW_PASSENGERS);
		passengerCarTest.alight(VALID_DEPARTING_PASSENGERS);
		assertEquals((Integer)(VALID_NEW_PASSENGERS - VALID_DEPARTING_PASSENGERS), passengerCarTest.numberOnBoard());
	}

	@Test
	public void testAlightWithTheNumDepartingPassengersEqualsTheNumPassengersOnBoard() throws TrainException {
		passengerCarTest = new PassengerCar(VALID_GROSS_WEIGHT, VALID_NUMBER_OF_SEATS);
		passengerCarTest.board(VALID_NEW_PASSENGERS);
		passengerCarTest.alight(VALID_DEPARTING_PASSENGERS * 2);
		assertEquals((Integer)(VALID_NEW_PASSENGERS - (VALID_DEPARTING_PASSENGERS * 2)), passengerCarTest.numberOnBoard());
	}
	
	@Test
	public void testNumberOnBoardWithPassengersGetOnMoreThanEmptySeats() throws TrainException {
		passengerCarTest = new PassengerCar(VALID_GROSS_WEIGHT, VALID_NUMBER_OF_SEATS);
		passengerCarTest.board(VALID_NUMBER_OF_SEATS * 2);
		assertTrue(passengerCarTest.numberOnBoard().equals(VALID_NUMBER_OF_SEATS));
	}
	
	@Test
	public void testNumberOnBoardAfterPassengersGetOn() throws TrainException {
		passengerCarTest = new PassengerCar(VALID_GROSS_WEIGHT, VALID_NUMBER_OF_SEATS);
		passengerCarTest.board(VALID_NEW_PASSENGERS);
		passengerCarTest.alight(VALID_DEPARTING_PASSENGERS);
		assertTrue(passengerCarTest.numberOnBoard().equals(VALID_NEW_PASSENGERS - VALID_DEPARTING_PASSENGERS));
	}
	
	@Test
	public void testNumberOnBoardAfterSetUpPassengerCar() throws TrainException {
		passengerCarTest = new PassengerCar(VALID_GROSS_WEIGHT, VALID_NUMBER_OF_SEATS);
		assertTrue(passengerCarTest.numberOnBoard().equals((Integer) 0));
	}
	
	
	@Test
	public void testNumberOfSeatsAfterPassengersGetOn() throws TrainException {
		passengerCarTest = new PassengerCar(VALID_GROSS_WEIGHT, VALID_NUMBER_OF_SEATS);
		passengerCarTest.board(VALID_NEW_PASSENGERS);
		passengerCarTest.alight(VALID_DEPARTING_PASSENGERS);
		assertTrue(passengerCarTest.numberOfSeats().equals(VALID_NUMBER_OF_SEATS));
	}
	
	//test toString() with VALID_GROSS_WEIGHT, VALID_GOOD_TYPE
	@Test 
	public void testToString() throws TrainException{
		passengerCarTest = new PassengerCar(VALID_GROSS_WEIGHT , VALID_NUMBER_OF_SEATS);
		passengerCarTest.board(VALID_NEW_PASSENGERS);
		passengerCarTest.alight(VALID_DEPARTING_PASSENGERS);
		assertEquals("Passenger (" + (VALID_NEW_PASSENGERS - VALID_DEPARTING_PASSENGERS) + "/" + VALID_NUMBER_OF_SEATS + ")",
					passengerCarTest.toString());
	}
}
