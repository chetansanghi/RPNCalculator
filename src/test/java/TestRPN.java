package test.java;

import junit.framework.TestCase;
import main.java.RPNCalculator;

public class TestRPN extends TestCase {
	
	RPNCalculator rpnCalculator = null;
	
	public void setUp() throws Exception{
		rpnCalculator = new RPNCalculator();
	}
	
	public void testCalculateResultEmpty() throws Exception{
		StringBuilder input = new StringBuilder();
		assertEquals(Double.MIN_VALUE, rpnCalculator.calculateResult(input.toString()));
	}

	public void testForOperandOnly() throws Exception{
		StringBuilder input = new StringBuilder();
		input.append("+");
		boolean result = false;
		try{
			rpnCalculator.calculateResult(input.toString());
		}catch(IllegalStateException ise){
			result = true;
		}
		assertTrue(result);
	}
	
	public void testForOneValueOnly() throws Exception{
		StringBuilder input = new StringBuilder();
		input.append("3");
		assertEquals(new Double(3.0), rpnCalculator.calculateResult(input.toString()));		
	}
	
	public void testForTwoValuesAndAdditionOperand()throws Exception{
		StringBuilder input = new StringBuilder();
		input.append("1");
		input.append(",");
		input.append("2");
		input.append(",");
		input.append("+");
		assertEquals(new Double(3.0), rpnCalculator.calculateResult(input.toString()));
	}

	public void testForTwoValuesOnly()throws Exception{
		StringBuilder input = new StringBuilder();
		input.append("1");
		input.append(",");
		input.append("2");
		boolean result = false;
		try{
			rpnCalculator.calculateResult(input.toString());
		}catch(IllegalStateException ise){
			result = true;
		}
		assertTrue(result);
	}

	public void testForOneValueAndOneOperandOnly()throws Exception{
		StringBuilder input = new StringBuilder();
		input.append("1");
		input.append(",");
		input.append("+");
		boolean result = false;
		try{
			rpnCalculator.calculateResult(input.toString());
		}catch(IllegalStateException ise){
			result = true;
		}
		assertTrue(result);
	}

	public void testForTwoValuesAndSubtractionOperand()throws Exception{
		StringBuilder input = new StringBuilder();
		input.append("1");
		input.append(",");
		input.append("2");
		input.append(",");
		input.append("-");
		assertEquals(new Double(-1.0), rpnCalculator.calculateResult(input.toString()));
	}

	public void testForTwoValuesAndDivisionOperand() throws Exception{
		StringBuilder input = new StringBuilder();
		input.append("1");
		input.append(",");
		input.append("2");
		input.append(",");
		input.append("/");
		assertEquals(new Double(0.5), rpnCalculator.calculateResult(input.toString()));
	}

	public void testForTwoValuesAndDivisionOperandZero() throws Exception{
		StringBuilder input = new StringBuilder();
		input.append("1");
		input.append(",");
		input.append("0");
		input.append(",");
		input.append("/");
		boolean result = false;
		try{
			rpnCalculator.calculateResult(input.toString());
		}catch(Exception ise){
			result = true;
		}
		assertTrue(result);

	}
	
	public void testForTwoValuesAndMultiplicationOperand() throws Exception{
		StringBuilder input = new StringBuilder();
		input.append("5");
		input.append(",");
		input.append("3");
		input.append(",");
		input.append("*");
		assertEquals(new Double(15.0), rpnCalculator.calculateResult(input.toString()));
	}

	public void testForThreeValuesAndAdditionOperand() throws Exception{
		StringBuilder input = new StringBuilder();
		input.append("1");
		input.append(",");
		input.append("2");
		input.append(",");
		input.append("3");
		input.append(",");
		input.append("+");

		boolean result = false;
		try{
			rpnCalculator.calculateResult(input.toString());
		}catch(IllegalStateException ise){
			result = true;
		}
		assertTrue(result);

	}

	public void testForTwoValuesAndTwoAdditionOperand() throws Exception{
		StringBuilder input = new StringBuilder();
		input.append("1");
		input.append(",");
		input.append("2");
		input.append(",");
		input.append("+");
		input.append(",");
		input.append("+");

		boolean result = false;
		try{
			rpnCalculator.calculateResult(input.toString());
		}catch(IllegalStateException ise){
			result = true;
		}
		assertTrue(result);

	}

	public void testForFourValuesAndAdditionOperand() throws Exception{
		StringBuilder input = new StringBuilder();
		input.append("1");
		input.append(",");
		input.append("2");
		input.append(",");
		input.append("3");
		input.append(",");
		input.append("5");
		input.append(",");
		input.append("+");

		boolean result = false;
		try{
			rpnCalculator.calculateResult(input.toString());
		}catch(IllegalStateException ise){
			result = true;
		}
		assertTrue(result);

	}

	public void testForThreeValuesAndTwoOperandInputError() throws Exception{
		StringBuilder input = new StringBuilder();
		input.append("1");
		input.append(",");
		input.append("2");
		input.append(",");
		input.append("-");
		input.append("3");
		input.append(",");
		input.append("+");
		boolean result = false;
		try{
			rpnCalculator.calculateResult(input.toString());
		}catch(IllegalStateException ise){
			result = true;
		}
		assertTrue(result);
	}
	
	public void testForThreeValuesAndTwoOperandSuccess() throws Exception{
		StringBuilder input = new StringBuilder();
		input.append("1");
		input.append(",");
		input.append("2");
		input.append(",");
		input.append("-");
		input.append(",");		
		input.append("3");
		input.append(",");
		input.append("+");
		assertEquals(new Double(2.0), rpnCalculator.calculateResult(input.toString()));
	}

	public void testForMoreThanFourValuesAndMultipleOperand() throws Exception {
		
		StringBuilder input = new StringBuilder();
		input.append("1");
		input.append(",");
		input.append("2");
		input.append(",");
		input.append("-");
		input.append(",");		
		input.append("3");
		input.append(",");
		input.append("+");
		input.append(",");		
		input.append("4");
		input.append(",");
		input.append("*");
		input.append(",");		
		input.append("5");
		input.append(",");
		input.append("/");		
		
		assertEquals(new Double(1.6), rpnCalculator.calculateResult(input.toString()));
	}
	
	public void testForTwoContinuousOperand() throws Exception{
		StringBuilder input = new StringBuilder();
		input.append("5");
		input.append(",");
		input.append("1");
		input.append(",");
		input.append("2");
		input.append(",");		
		input.append("+");
		input.append(",");
		input.append("4");
		input.append(",");		
		input.append("*");
		input.append(",");
		input.append("+");
		input.append(",");		
		input.append("3");
		input.append(",");
		input.append("-");		
		
		assertEquals(new Double(14.0), rpnCalculator.calculateResult(input.toString()));
	}
	
	public void tearDown() throws Exception{
		rpnCalculator = null;
	}
	
}
