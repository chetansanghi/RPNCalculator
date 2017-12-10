package main.java;

import main.java.RPN.Operations;

//Commented by Neha
public class Addition extends Operations{

	@Override
	public Double calculate(Double operand1, Double operand2) throws Exception {
		
		if(operand1 != null && operand2 != null){
			return (operand1 + operand2);
		}
		return null;
	}
}
