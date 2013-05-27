package asgn2Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import asgn2Exceptions.TrainException;


public class TrainExceptionTest {
	
	@Test
	public void testTrainExceptionExtendsException() {
		TrainException trainException = new TrainException("Train Exception Message");
		assertTrue("TrainException has not been created properly",
					trainException instanceof Exception);
	}
}