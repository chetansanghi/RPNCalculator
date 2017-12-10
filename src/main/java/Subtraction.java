package main.java;

import main.java.RPN.Operations;

public class Subtraction extends Operations{

	@Override
	
	//Method to subtract
	public Double calculate(Double operand1, Double operand2) throws Exception {
		if(operand1 != null && operand2 != null){
			return (operand2 - operand1);
		}
		return null;
	}

}
